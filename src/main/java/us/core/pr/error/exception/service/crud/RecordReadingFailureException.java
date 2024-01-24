package us.core.pr.error.exception.service.crud;

public class RecordReadingFailureException
        extends RuntimeException
{
    public RecordReadingFailureException(Exception e)
    {
        super(e);
    }
}
