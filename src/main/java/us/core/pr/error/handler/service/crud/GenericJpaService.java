package us.core.pr.error.handler.service.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.error.exception.service.crud.RecordCreatingFailureException;
import us.core.pr.error.exception.service.crud.RecordDeletingFailureException;
import us.core.pr.error.exception.service.crud.RecordReadingFailureException;
import us.core.pr.error.exception.service.crud.RecordUpdatingFailureException;

import java.io.Serializable;

@ControllerAdvice
public class GenericJpaService
        implements Serializable
{

    @ExceptionHandler(RecordCreatingFailureException.class)
    public ResponseEntity<Object> handleRecordCreatingFailureException(WebRequest webRequest, Exception e)
    {
        return null;
    }

    @ExceptionHandler(RecordReadingFailureException.class)
    public ResponseEntity<Object> handleRecordReadingFailureException(WebRequest webRequest, Exception e)
    {
        return null;
    }

    @ExceptionHandler(RecordUpdatingFailureException.class)
    public ResponseEntity<Object> handleRecordUpdatingFailureException(WebRequest webRequest, Exception e)
    {
        return null;
    }

    @ExceptionHandler(RecordDeletingFailureException.class)
    public ResponseEntity<Object> handleRecordDeletingFailureException(WebRequest webRequest, Exception e)
    {
        return null;
    }
}
