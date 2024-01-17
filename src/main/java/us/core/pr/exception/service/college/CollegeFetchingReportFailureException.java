package us.core.pr.exception.service.college;

public class CollegeFetchingReportFailureException
        extends RuntimeException
{

    public CollegeFetchingReportFailureException(Exception e)
    {
        super(e);
    }

}
