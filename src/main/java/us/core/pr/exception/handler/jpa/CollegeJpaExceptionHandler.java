package us.core.pr.exception.handler.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.jpa.college.CollegeEntityCreatingFailureException;
import us.core.pr.exception.jpa.college.CollegeEntityReadingFailureException;
import us.core.pr.exception.jpa.college.CollegeEntityRemovingFailureException;
import us.core.pr.exception.jpa.college.CollegeEntityUpdatingFailureException;
import us.core.pr.exception.utils.mapper.MapperNotFoundException;

import javax.xml.ws.Response;
import java.io.Serializable;

@ControllerAdvice
public class CollegeJpaExceptionHandler
        implements Serializable
{

    @ExceptionHandler(CollegeEntityCreatingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> collegeEntityCreatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(CollegeEntityReadingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> collegeEntityReadingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(CollegeEntityUpdatingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> collegeEntityUpdatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(CollegeEntityRemovingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> collegeEntityRemovingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }
}
