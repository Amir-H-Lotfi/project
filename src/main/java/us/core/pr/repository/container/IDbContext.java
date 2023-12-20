package us.core.pr.repository.container;

import java.io.Serializable;

public interface IDbContext
        extends Serializable
{
    <T> T getRepository(Class<T> t);
}
