package MovieRating.infrastructure.gateway;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.gateway.MovieGateway;
import MovieRating.infrastructure.mapper.MovieEntityMapping;
import MovieRating.infrastructure.persistence.MovieRatingEntity;
import MovieRating.infrastructure.persistence.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RepositoryGateway implements MovieGateway {

    private final MovieEntityMapping mapping;
    private final MovieRepository repository;

    @Override
    public List<MovieRating> findAllMovies() {
        List<MovieRatingEntity> findAll = repository.findAll();
        return findAll.stream()
                .map(mapping::toMovie)
                .toList();
    }

    @Override
    public MovieRating saveMovie(MovieRating movieRating) {
        MovieRatingEntity save = repository.save(mapping.toEntity(movieRating));
        return mapping.toMovie(save);
    }

}
