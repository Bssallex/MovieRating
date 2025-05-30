package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;

import java.util.Optional;

public interface MovieFindByName {

    Optional<MovieRating> execute(MovieRating title);
}
