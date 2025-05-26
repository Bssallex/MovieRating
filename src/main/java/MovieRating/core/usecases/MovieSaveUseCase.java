package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;

public interface MovieSaveUseCase {

    MovieRating execute(MovieRating movieRating);
}
