package MovieRating.infrastructure.presentation;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.usecases.MovieDeleteByIdUseCase;
import MovieRating.core.usecases.MovieFindAllUseCase;
import MovieRating.core.usecases.MovieSaveUseCase;
import MovieRating.core.usecases.MovieSetByIdUseCase;
import MovieRating.infrastructure.dtos.MovieRatingDto;
import MovieRating.infrastructure.mapper.MovieRatingMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class MovieRatingController {

    private final MovieSaveUseCase movieSaveUseCase;
    private final MovieFindAllUseCase movieFindAllUseCase;
    private final MovieSetByIdUseCase movieSetByIdUseCase;
    private final MovieDeleteByIdUseCase movieDeleteByIdUseCase;

    private final MovieRatingMapping mapping;

    @GetMapping("findmovie")
    public List<MovieRatingDto> findAllMovie(){
        List<MovieRating> findall = movieFindAllUseCase.execute();
        return findall.stream()
                .map(mapping::toDto)
                .toList();
    }

    @PostMapping("moviesave")
    public MovieRatingDto saveMovie(@RequestBody MovieRatingDto movie){
        MovieRating save = movieSaveUseCase.execute(mapping.toMovie(movie));
        return mapping.toDto(save);
    }

    @PutMapping("setmovie/{id}")
    public Optional<MovieRatingDto> setMovieId(@PathVariable Long id, @RequestBody MovieRating movieRating){
        Optional<MovieRating> setId = movieSetByIdUseCase.execute(id, movieRating);
        return setId.map(mapping::toDto);
    }

    @DeleteMapping("deletemovie/{id}")
    public Optional<MovieRatingDto> deleteMovieId(@PathVariable Long id){
        Optional<MovieRating> delete = movieDeleteByIdUseCase.execute(id);
        return delete.map(mapping::toDto);
    }

}
