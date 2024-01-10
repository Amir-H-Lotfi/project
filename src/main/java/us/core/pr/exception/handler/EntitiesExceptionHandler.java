package us.core.pr.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.entity.CollegeRecordNotFoundException;
import us.core.pr.exception.entity.CourseRecordNotFoundException;
import us.core.pr.exception.entity.ProfessorRecordNotFoundException;
import us.core.pr.exception.entity.StudentRecordNotFoundException;

import java.io.Serializable;

@ControllerAdvice
public class EntitiesExceptionHandler
        implements Serializable
{
    @ExceptionHandler(CollegeRecordNotFoundException.class)
    public ResponseEntity<Object> collegeRecordNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(CourseRecordNotFoundException.class)
    public ResponseEntity<Object> courseRecordNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(ProfessorRecordNotFoundException.class)
    public ResponseEntity<Object> professorRecordNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(StudentRecordNotFoundException.class)
    public ResponseEntity<Object> studentRecordNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

}
