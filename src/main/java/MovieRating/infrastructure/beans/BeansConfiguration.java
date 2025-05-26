package MovieRating.infrastructure.beans;

import MovieRating.core.gateway.MovieGateway;
import MovieRating.core.usecases.MovieFindAllImpl;
import MovieRating.core.usecases.MovieFindAllUseCase;
import MovieRating.core.usecases.MovieSaveImpl;
import MovieRating.core.usecases.MovieSaveUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public MovieSaveUseCase movieSaveUseCase(MovieGateway gateway){
        return new MovieSaveImpl(gateway);
    }

    @Bean
    public MovieFindAllUseCase movieFindAllUseCase(MovieGateway gateway){
        return new MovieFindAllImpl(gateway);
    }
}
