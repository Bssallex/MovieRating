package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;

import java.util.Optional;

public interface MovieDeleteByIdUseCase {

    Optional<MovieRating> execute(Long id);
}
