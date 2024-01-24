package us.core.pr.error.handler.service.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.error.exception.service.student.StudentFetchingReportFailureException;
import us.core.pr.error.exception.service.student.StudentTakingCourseFailureException;

import java.io.Serializable;

@ControllerAdvice
public class StudentServiceExceptionHandler
        implements Serializable
{

    @ExceptionHandler(StudentTakingCourseFailureException.class)
    public ResponseEntity<Object> studentTakingCourseFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        
        return null;
    }

    @ExceptionHandler(StudentFetchingReportFailureException.class)
    public ResponseEntity<Object> studentFetchingReportFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }
}
