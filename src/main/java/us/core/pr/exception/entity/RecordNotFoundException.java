package us.core.pr.exception.entity;


import java.io.Serializable;

public abstract class RecordNotFoundException
        extends RuntimeException
        implements Serializable
{
    public RecordNotFoundException()
    {
        super();
    }
}
