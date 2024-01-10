package us.core.pr.domain.entity.listener.abstractions.interfaces;

import java.io.Serializable;

public interface IEntityListener<E>
        extends Serializable
{
    void persist(E e);

    void remove(E e);

    void update(E e);
}
