package us.core.pr.error.handler.service.professor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.error.exception.service.professor.ProfessorAddingCourseFailureException;
import us.core.pr.error.exception.service.professor.ProfessorFetchingReportFailureException;

import java.io.Serializable;

@ControllerAdvice
public class ProfessorServiceExceptionHandler
        implements Serializable
{

    @ExceptionHandler(ProfessorAddingCourseFailureException.class)
    public ResponseEntity<Object> professorAddingCourseFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(ProfessorFetchingReportFailureException.class)
    public ResponseEntity<Object> professorFetchingReportFailureException(Exception e, WebRequest webRequest)
    {
        return null;
    }
}
