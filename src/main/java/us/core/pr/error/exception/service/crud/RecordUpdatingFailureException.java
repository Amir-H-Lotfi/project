package us.core.pr.error.exception.service.crud;

public class RecordUpdatingFailureException
        extends RuntimeException
{
    public RecordUpdatingFailureException(Exception e)
    {
        super(e);
    }
}
