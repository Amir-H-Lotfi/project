package us.core.pr.exception.handler.jpae;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.jpa.student.*;

@ControllerAdvice
public class StudentJpaExceptionHandler
{


    @ExceptionHandler(StudentEntityCreatingFailureException.class)
    public ResponseEntity<Object> studentEntityCreatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(StudentEntityReadingFailureException.class)
    public ResponseEntity<Object> studentEntityReadingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(StudentEntityUpdatingFailureException.class)
    public ResponseEntity<Object> studentEntityUpdatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(StudentEntityRemovingFailureException.class)
    public ResponseEntity<Object> studentEntityRemovingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }
}
