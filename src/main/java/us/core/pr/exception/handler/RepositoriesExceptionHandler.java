package us.core.pr.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.repository.RepositoryNotFoundException;

import java.io.Serializable;

@ControllerAdvice
public class RepositoriesExceptionHandler
        implements Serializable
{

    @ExceptionHandler(RepositoryNotFoundException.class)
    public ResponseEntity<Object> repositoryNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }
}
