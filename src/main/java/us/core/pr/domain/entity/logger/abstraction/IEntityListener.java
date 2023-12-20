package us.core.pr.domain.entity.logger.abstraction;

import java.io.Serializable;

public interface IEntityListener<E>
        extends Serializable
{
    void persist(E e);

    void remove(E e);

    void update(E e);
}
