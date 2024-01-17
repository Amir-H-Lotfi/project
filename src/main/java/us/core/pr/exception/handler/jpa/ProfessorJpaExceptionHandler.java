package us.core.pr.exception.handler.jpa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.jpa.professor.*;

import java.io.Serializable;

@ControllerAdvice
public class ProfessorJpaExceptionHandler
        implements Serializable
{

    @ExceptionHandler(ProfessorEntityCreatingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> professorEntityCreatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(ProfessorEntityReadingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> professorEntityReadingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(ProfessorEntityUpdatingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> professorEntityUpdatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(ProfessorEntityRemovingFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> professorEntityRemovingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return ResponseEntity.badRequest().build();
    }
}
