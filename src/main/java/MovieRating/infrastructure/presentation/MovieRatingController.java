package MovieRating.infrastructure.presentation;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.usecases.*;
import MovieRating.infrastructure.dtos.MovieRatingDto;
import MovieRating.infrastructure.exceptions.NotFoundExceptions;
import MovieRating.infrastructure.mapper.MovieRatingMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class MovieRatingController {

    private final MovieSaveUseCase movieSaveUseCase;
    private final MovieFindAllUseCase movieFindAllUseCase;
    private final MovieSetByIdUseCase movieSetByIdUseCase;
    private final MovieDeleteByIdUseCase movieDeleteByIdUseCase;
    private final MovieFindByName movieFindByName;

    private final MovieRatingMapping mapping;

    @GetMapping("findmovie")
    public ResponseEntity<Map<String, Object>> findAllMovie(){
        List<MovieRating> findall = movieFindAllUseCase.execute();

        Map<String, Object> find = new HashMap<>();
        find.put("message", "Lista de filmes");
        find.put("data", findall.stream()
                .map(mapping::toDto)
                .toList());

        return ResponseEntity.ok(find);
    }

    @GetMapping("titlemovie")
    public ResponseEntity<Map<String, Object>> findMovieTitle(@RequestBody MovieRatingDto dto){
        Optional<MovieRating> movieTitle = movieFindByName.execute(mapping.toMovie(dto));

        if (movieTitle.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Filme não encontrado");
            response.put("data", List.of());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Map<String, Object> find = new HashMap<>();
        find.put("message", "Filme");
        find.put("data", List.of(mapping.toDto(movieTitle.get())));

        return ResponseEntity.ok(find);

    }

    @PostMapping("moviesave")
    public ResponseEntity<Map<String, Object>> saveMovie(@RequestBody MovieRatingDto movie){
        MovieRating save = movieSaveUseCase.execute(mapping.toMovie(movie));

        Map<String, Object> created = new HashMap<>();
        created.put("message", "Filme criado");
        created.put("data", mapping.toDto(save));

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("setmovie/{id}")
    public ResponseEntity<MovieRatingDto> setMovieId(@PathVariable Long id, @RequestBody MovieRating movieRating){
        MovieRating setId = movieSetByIdUseCase.execute(id, movieRating)
                .orElseThrow(() -> new NotFoundExceptions("Atenção! Não foi encontrado nenhum filme com esse id: " + id));

        return ResponseEntity.ok(mapping.toDto(setId));
    }

    @DeleteMapping("deletemovie/{id}")
    public ResponseEntity<Map<String, String>> deleteMovieId(@PathVariable Long id){
        movieDeleteByIdUseCase.execute(id)
                .orElseThrow(() -> new NotFoundExceptions("Atenção! Não foi encontrado nenhum filme com esse id: " + id));

        Map<String, String> message = new HashMap<>();
        message.put("message", "Objeto deletado");

        return ResponseEntity.ok(message);
    }

}
