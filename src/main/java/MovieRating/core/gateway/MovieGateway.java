package MovieRating.core.gateway;

import MovieRating.core.entity.MovieRating;

import java.util.List;

public interface MovieGateway{

    MovieRating saveMovie(MovieRating movieRating);
    List<MovieRating> findAllMovies();
}
