package us.core.pr.exception.handler.jpa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.jpa.student.*;

@ControllerAdvice
public class StudentJpaExceptionHandler
{


    @ExceptionHandler(StudentEntityCreatingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> studentEntityCreatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(StudentEntityReadingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> studentEntityReadingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(StudentEntityUpdatingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> studentEntityUpdatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(StudentEntityRemovingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> studentEntityRemovingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }
}
