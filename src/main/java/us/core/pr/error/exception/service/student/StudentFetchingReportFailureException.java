package us.core.pr.error.exception.service.student;

public class StudentFetchingReportFailureException
        extends RuntimeException
{
    public StudentFetchingReportFailureException(Exception e)
    {
        super(e);
    }
}
