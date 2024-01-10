package us.core.pr.repository.container.abstraction.interfaces;

import java.io.Serializable;

public interface IDbContext
        extends Serializable
{
    <T> T getRepository(Class<T> t);
}
