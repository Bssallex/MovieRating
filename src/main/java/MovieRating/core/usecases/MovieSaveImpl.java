package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.gateway.MovieGateway;

public class MovieSaveImpl implements MovieSaveUseCase{

    private final MovieGateway movieGateway;

    public MovieSaveImpl(MovieGateway movieGateway) {
        this.movieGateway = movieGateway;
    }

    @Override
    public MovieRating execute(MovieRating movieRating) {
        return movieGateway.saveMovie(movieRating);
    }
}
