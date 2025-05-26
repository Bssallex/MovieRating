package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;

import java.util.List;

public interface MovieFindAllUseCase {

    List<MovieRating> execute();
}
