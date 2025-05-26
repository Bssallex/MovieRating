package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.gateway.MovieGateway;

import java.util.Optional;

public class MovieSetByIdImpl implements MovieSetByIdUseCase {

    private final MovieGateway gateway;

    public MovieSetByIdImpl(MovieGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Optional<MovieRating> execute(Long id, MovieRating rating) {
        return gateway.findMovieById(id, rating);
    }
}
