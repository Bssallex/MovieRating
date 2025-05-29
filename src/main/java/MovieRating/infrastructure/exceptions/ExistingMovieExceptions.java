package MovieRating.infrastructure.exceptions;

public class ExistingMovieExceptions extends RuntimeException{

    public ExistingMovieExceptions(String message){
        super(message);
    }
}
