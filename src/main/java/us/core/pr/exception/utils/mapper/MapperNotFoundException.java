package us.core.pr.exception.utils.mapper;

import java.io.Serializable;

public class MapperNotFoundException
        extends RuntimeException
        implements Serializable
{
    public MapperNotFoundException(Exception e)
    {
        super(e);
    }
}
