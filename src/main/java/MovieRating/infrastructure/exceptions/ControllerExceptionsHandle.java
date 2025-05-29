package MovieRating.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandle {

    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NotFoundExceptions notFoundExceptions){

        Map<String, String> exceptions = new HashMap<>();
        exceptions.put("Error: ", notFoundExceptions.getMessage());
        exceptions.put("Message: ", "The request event was not found, check the identifier try again");
        return new ResponseEntity<>(exceptions, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ExistingMovieExceptions.class)
    public ResponseEntity<Map<String, String>> handleExistingMovie(ExistingMovieExceptions existingMovieExceptions){

        Map<String, String> exceptions = new HashMap<>();
        exceptions.put("Error: ", existingMovieExceptions.getMessage());
        exceptions.put("Message: ", "Oops! Try Again");
        return new ResponseEntity<>(exceptions, HttpStatus.CONFLICT);
    }


}
