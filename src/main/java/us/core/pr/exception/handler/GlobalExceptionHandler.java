package us.core.pr.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.IllegalHeadOfDepartmentAssignmentException;
import us.core.pr.exception.RecordNotFoundException;
import us.core.pr.exception.entity.CollegeRecordNotFoundException;
import us.core.pr.exception.entity.CourseRecordNotFoundException;
import us.core.pr.exception.entity.ProfessorRecordNotFoundException;
import us.core.pr.exception.entity.StudentRecordNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;

@ControllerAdvice
public class GlobalExceptionHandler
        implements Serializable
{
    public GlobalExceptionHandler() {}

    @ExceptionHandler(value = IllegalHeadOfDepartmentAssignmentException.class)
    public ResponseEntity<Object> illegalHeadOfDepartmentAssignmentExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> recordNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }


    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> entityNotfoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(value = CollegeRecordNotFoundException.class)
    public ResponseEntity<Object> collegeRecordNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(value = CourseRecordNotFoundException.class)
    public ResponseEntity<Object> courseRecordNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(value = ProfessorRecordNotFoundException.class)
    public ResponseEntity<Object> professorRecordNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(value = StudentRecordNotFoundException.class)
    public ResponseEntity<Object> studentRecordNotFoundExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }


}

