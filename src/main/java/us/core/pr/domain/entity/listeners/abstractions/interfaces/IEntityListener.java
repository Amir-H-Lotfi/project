package us.core.pr.domain.entity.listeners.abstractions.interfaces;

import java.io.Serializable;

public interface IEntityListener<E>
        extends Serializable
{
    void persist(E e);

    void remove(E e);

    void update(E e);
}
