package us.core.pr.exception.jpa;


import java.io.Serializable;

public class RecordNotFoundException
        extends RuntimeException
        implements Serializable
{
    public RecordNotFoundException(String message)
    {
        super(message);
    }

    public RecordNotFoundException()
    {
        super();
    }
}
