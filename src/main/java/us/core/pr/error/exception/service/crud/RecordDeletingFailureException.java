package us.core.pr.error.exception.service.crud;

public class RecordDeletingFailureException
        extends RuntimeException
{
    public RecordDeletingFailureException(Exception e)
    {
        super(e);
    }
}
