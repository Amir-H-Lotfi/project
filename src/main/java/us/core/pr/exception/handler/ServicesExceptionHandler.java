package us.core.pr.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.service.IllegalHeadOfDepartmentAssignmentException;

import java.io.Serializable;

@ControllerAdvice
public class ServicesExceptionHandler
        implements Serializable
{
    @ExceptionHandler(IllegalHeadOfDepartmentAssignmentException.class)
    public ResponseEntity<Object> illegalHeadOfDepartmentAssignmentExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }
}
