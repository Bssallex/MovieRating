package MovieRating.core.gateway;

import MovieRating.core.entity.MovieRating;

import java.util.List;
import java.util.Optional;

public interface MovieGateway{

    MovieRating saveMovie(MovieRating movieRating);
    List<MovieRating> findAllMovies();
    Optional<MovieRating> findMovieById(Long id, MovieRating rating);
    Optional<MovieRating> deleteMovieId(Long id);
}
