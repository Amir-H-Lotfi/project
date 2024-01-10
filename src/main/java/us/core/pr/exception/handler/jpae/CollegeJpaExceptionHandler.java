package us.core.pr.exception.handler.jpae;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.jpa.college.CollegeEntityCreatingFailureException;
import us.core.pr.exception.jpa.college.CollegeEntityReadingFailureException;
import us.core.pr.exception.jpa.college.CollegeEntityRemovingFailureException;
import us.core.pr.exception.jpa.college.CollegeEntityUpdatingFailureException;

import java.io.Serializable;

@ControllerAdvice
public class CollegeJpaExceptionHandler
implements Serializable
{
    @ExceptionHandler(CollegeEntityCreatingFailureException.class)
    public ResponseEntity<Object> collegeEntityCreatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(CollegeEntityReadingFailureException.class)
    public ResponseEntity<Object> collegeEntityReadingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(CollegeEntityUpdatingFailureException.class)
    public ResponseEntity<Object> collegeEntityUpdatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(CollegeEntityRemovingFailureException.class)
    public ResponseEntity<Object> collegeEntityRemovingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }
}
