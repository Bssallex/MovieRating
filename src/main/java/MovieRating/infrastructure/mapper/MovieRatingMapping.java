package MovieRating.infrastructure.mapper;

import MovieRating.core.entity.MovieRating;
import MovieRating.infrastructure.dtos.MovieRatingDto;
import org.springframework.stereotype.Component;

@Component
public class MovieRatingMapping {

   public MovieRatingDto toDto(MovieRating movie){
       return new MovieRatingDto(
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

   public MovieRating toMovie(MovieRatingDto dto){
       return new MovieRating(
               dto.id(),
               dto.movieTitle(),
               dto.description(),
               dto.genre(),
               dto.review(),
               dto.userExperience(),
               dto.rating(),
               dto.releaseYear(),
               dto.watchedAt()
       );
   }
}
