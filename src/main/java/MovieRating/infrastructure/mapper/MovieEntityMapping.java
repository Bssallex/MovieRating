package MovieRating.infrastructure.mapper;

import MovieRating.core.entity.MovieRating;
import MovieRating.infrastructure.persistence.MovieRatingEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieEntityMapping {

    public MovieRatingEntity toEntity(MovieRating movie){
        return new MovieRatingEntity(
                movie.id(),
                movie.movieTitle(),
                movie.description(),
                movie.genre(),
                movie.review(),
                movie.userExperience(),
                movie.rating(),
                movie.releaseYear(),
                movie.watchedAt()
        );
    }

    public MovieRating toMovie(MovieRatingEntity movie){
         return new MovieRating(
                 movie.getId(),
                 movie.getMovieTitle(),
                 movie.getDescription(),
                 movie.getGenre(),
                 movie.getReview(),
                 movie.getUserExperience(),
                 movie.getRating(),
                 movie.getReleaseYear(),
                 movie.getWatchedAt()
         );
    }
}
