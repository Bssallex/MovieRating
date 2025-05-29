package MovieRating.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieRatingEntity, Long> {

    List<MovieRatingEntity> findAllByOrderByIdAsc();
    Optional<MovieRatingEntity> findByMovieTitle(String title);
}
