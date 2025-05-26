package MovieRating.infrastructure.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;


public record MovieRatingDto(
        Long id,
        String movieTitle,
        String description,
        String genre,
        String review,
        String userExperience,
        BigDecimal rating,
        LocalDate releaseYear,
        LocalDate watchedAt) {
}
