package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.gateway.MovieGateway;

import java.util.List;

public class MovieFindAllImpl implements MovieFindAllUseCase{

    private final MovieGateway gateway;

    public MovieFindAllImpl(MovieGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<MovieRating> execute() {
        return gateway.findAllMovies();
    }
}
