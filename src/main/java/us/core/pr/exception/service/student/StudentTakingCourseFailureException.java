package us.core.pr.exception.service.student;

public class StudentTakingCourseFailureException
        extends RuntimeException

{
    public StudentTakingCourseFailureException(Exception e)
    {
        super(e);
    }
}
