package us.core.pr.exception;

public class RepositoryNotFoundException
        extends RuntimeException
{
    public RepositoryNotFoundException()
    {
        super();
    }

    public RepositoryNotFoundException(String message)
    {
        super(message);
    }
}
