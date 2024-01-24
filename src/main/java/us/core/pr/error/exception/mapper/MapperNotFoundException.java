package us.core.pr.error.exception.mapper;

import java.io.Serializable;

public class MapperNotFoundException
        extends RuntimeException
{
    public MapperNotFoundException(Exception e)
    {
        super(e);
    }
}
