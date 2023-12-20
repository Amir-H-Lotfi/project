package us.core.pr.exception;

public class NoSuchRepositoryException
        extends RuntimeException
{
    public NoSuchRepositoryException()
    {
        super();
    }

    public NoSuchRepositoryException(String message)
    {
        super(message);
    }
}
