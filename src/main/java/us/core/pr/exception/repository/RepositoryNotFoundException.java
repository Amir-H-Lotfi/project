package us.core.pr.exception.repository;

import java.io.Serializable;

public class RepositoryNotFoundException
        extends RuntimeException
        implements Serializable
{
    public RepositoryNotFoundException()
    {
        super();
    }

}
