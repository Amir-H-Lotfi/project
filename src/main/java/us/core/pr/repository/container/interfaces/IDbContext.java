package us.core.pr.repository.container.interfaces;

import java.io.Serializable;

public interface IDbContext
        extends Serializable
{
    <T> T getRepository(Class<T> t);
}
