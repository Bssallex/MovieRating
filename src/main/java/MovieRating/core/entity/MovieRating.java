package MovieRating.core.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieRating(Long id,
                          String movieTitle,
                          String description,
                          String genre,
                          String review,
                          String userExperience,
                          BigDecimal rating,
                          LocalDate releaseYear,
                          LocalDate dateWatched
                          ) {
}
