package MovieRating.core.usecases;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.gateway.MovieGateway;

import java.util.Optional;

public class MovieDeleteByIdImpl implements MovieDeleteByIdUseCase{

    private final MovieGateway gateway;

    public MovieDeleteByIdImpl(MovieGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Optional<MovieRating> execute(Long id) {
        return gateway.deleteMovieId(id);
    }
}
