package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.gateway.MovieGateway;

import java.util.Optional;

public class MovieFindByNameImpl implements MovieFindByName{

    private final MovieGateway gateway;

    public MovieFindByNameImpl(MovieGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Optional<MovieRating> execute(MovieRating title) {
        return gateway.movieByName(title);
    }
}
