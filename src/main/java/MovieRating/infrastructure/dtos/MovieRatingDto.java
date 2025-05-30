package MovieRating.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

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
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate releaseYear,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate watchedAt) {
}
