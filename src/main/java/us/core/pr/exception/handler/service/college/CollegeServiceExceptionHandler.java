package us.core.pr.exception.handler.service.college;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.core.pr.exception.service.college.CollegeFetchingReportFailureException;
import us.core.pr.exception.service.college.HeadOfDepartmentAssignmentFailureException;
import us.core.pr.exception.service.college.IllegalHeadOfDepartmentAssignmentException;
import us.core.pr.exception.service.college.ProfessorToCollegeAssignmentFailureException;

import java.io.Serializable;

@ControllerAdvice
public class CollegeServiceExceptionHandler
        implements Serializable
{
    @ExceptionHandler(CollegeFetchingReportFailureException.class)
    public ResponseEntity<Object> collegeFetchingReportFailureExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(HeadOfDepartmentAssignmentFailureException.class)
    public ResponseEntity<Object> headOfDepartmentAssignmentFailureException(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(IllegalHeadOfDepartmentAssignmentException.class)
    public ResponseEntity<Object> illegalHeadOfDepartmentAssignmentExceptionHandler(Exception e, WebRequest webRequest)
    {
        return null;
    }

    @ExceptionHandler(ProfessorToCollegeAssignmentFailureException.class)
    public ResponseEntity<Object> professorToCollegeAssignmentFailureException(Exception e, WebRequest webRequest)
    {
        return null;
    }
}
