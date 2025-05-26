package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;

import java.util.Optional;

public interface MovieSetByIdUseCase {

    Optional<MovieRating> execute(Long id, MovieRating rating);
}
