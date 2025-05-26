package MovieRating.infrastructure.presentation;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.usecases.MovieFindAllUseCase;
import MovieRating.core.usecases.MovieSaveUseCase;
import MovieRating.infrastructure.dtos.MovieRatingDto;
import MovieRating.infrastructure.mapper.MovieRatingMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class MovieRatingController {

    private final MovieSaveUseCase movieSaveUseCase;
    private final MovieFindAllUseCase movieFindAllUseCase;

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

}
