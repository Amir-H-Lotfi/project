package us.core.pr.error.exception.service.crud;

public class RecordCreatingFailureException
        extends RuntimeException
{
    public RecordCreatingFailureException(Exception e)
    {
        super(e);
    }
}
