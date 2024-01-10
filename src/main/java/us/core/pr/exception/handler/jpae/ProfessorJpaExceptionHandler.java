package us.core.pr.exception.handler.jpae;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.jpa.professor.*;

import java.io.Serializable;

@ControllerAdvice
public class ProfessorJpaExceptionHandler
        implements Serializable
{

    @ExceptionHandler(ProfessorEntityCreatingFailureException.class)
    public ResponseEntity<Object> professorEntityCreatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(ProfessorEntityReadingFailureException.class)
    public ResponseEntity<Object> professorEntityReadingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(ProfessorEntityUpdatingFailureException.class)
    public ResponseEntity<Object> professorEntityUpdatingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(ProfessorEntityRemovingFailureException.class)
    public ResponseEntity<Object> professorEntityRemovingFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }
}
