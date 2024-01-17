package us.core.pr.exception.service.professor;

public class ProfessorAddingCourseFailureException
        extends RuntimeException
{

    public ProfessorAddingCourseFailureException(Exception e)
    {
        super(e);
    }
}
