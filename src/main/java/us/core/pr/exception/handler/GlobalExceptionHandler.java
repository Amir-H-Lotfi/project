package us.core.pr.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.IllegalHeadOfDepartmentAssignmentException;
import us.core.pr.exception.RecordNotFoundException;

import java.io.Serializable;

@ControllerAdvice
public class GlobalExceptionHandler
        implements Serializable
{
    public GlobalExceptionHandler() {}

    @ExceptionHandler(value = IllegalHeadOfDepartmentAssignmentException.class)
    public ResponseEntity<Object> IllegalHeadOfDepartmentAssignmentExceptionHandler(Exception exception, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> RecordNotFoundExceptionHandler(Exception exception, WebRequest webRequest)
    {
        return null;
    }

}

