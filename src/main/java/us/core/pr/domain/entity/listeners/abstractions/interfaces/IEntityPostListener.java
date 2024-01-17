package us.core.pr.domain.entity.listeners.abstractions.interfaces;

public interface IEntityPostListener<E>
        extends IEntityListener<E>
{
    void load(E e);
}
