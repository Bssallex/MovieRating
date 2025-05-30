package MovieRating.infrastructure.beans;

import MovieRating.core.gateway.MovieGateway;
import MovieRating.core.usecases.*;
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

    @Bean
    public MovieSetByIdUseCase movieSetByIdUseCase(MovieGateway gateway){
        return new MovieSetByIdImpl(gateway);
    }

    @Bean
    public MovieDeleteByIdUseCase movieDeleteByIdUseCase(MovieGateway gateway){
        return new MovieDeleteByIdImpl(gateway);
    }

    @Bean
    public MovieFindByName movieFindByName(MovieGateway gateway){
        return new MovieFindByNameImpl(gateway);
    }
}
