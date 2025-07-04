package MovieRating.infrastructure.gateway;

import MovieRating.core.entity.MovieRating;
import MovieRating.core.gateway.MovieGateway;
import MovieRating.infrastructure.exceptions.ExistingMovieExceptions;
import MovieRating.infrastructure.mapper.MovieEntityMapping;
import MovieRating.infrastructure.persistence.MovieRatingEntity;
import MovieRating.infrastructure.persistence.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RepositoryGateway implements MovieGateway {

    private final MovieEntityMapping mapping;
    private final MovieRepository repository;

    @Override
    public List<MovieRating> findAllMovies() {
        List<MovieRatingEntity> findAll = repository.findAllByOrderByIdAsc();
        return findAll.stream()
                .map(mapping::toMovie)
                .toList();
    }

    @Override
    public Optional<MovieRating> movieByName(MovieRating title) {

        Optional<MovieRatingEntity> movieName = repository.findByMovieTitle(title.movieTitle().toLowerCase());
        return movieName.map(mapping::toMovie);
    }

    @Override
    public MovieRating saveMovie(MovieRating movieRating) {
        String titleLowerCase = movieRating.movieTitle().toLowerCase();

        if(repository.findByMovieTitle(titleLowerCase).isPresent()){
            throw new ExistingMovieExceptions("Atenção! Esse título já existe nos registros");
        }

        MovieRatingEntity save = repository.save(mapping.toEntity(movieRating));
        return mapping.toMovie(save);
    }


    @Override
    public Optional<MovieRating> findMovieById(Long id, MovieRating rating) {
        Optional<MovieRatingEntity> findId = repository.findById(id);
        return findId.map(movieId -> {
            movieId.setId(movieId.getId());
            movieId.setMovieTitle(rating.movieTitle());
            movieId.setDescription(rating.description());
            movieId.setGenre(rating.genre());
            movieId.setReview(rating.review());
            movieId.setUserExperience(rating.userExperience());
            movieId.setRating(rating.rating());
            movieId.setReleaseYear(rating.releaseYear());
            movieId.setWatchedAt(rating.watchedAt());

            repository.save(movieId);

            return mapping.toMovie(movieId);
        });
    }

    @Override
    public Optional<MovieRating> deleteMovieId(Long id) {
        Optional<MovieRatingEntity> deleteId = repository.findById(id);
        return deleteId
                .map(delete -> {
                    repository.delete(delete);
                    return mapping.toMovie(delete);
                });
    }


}
