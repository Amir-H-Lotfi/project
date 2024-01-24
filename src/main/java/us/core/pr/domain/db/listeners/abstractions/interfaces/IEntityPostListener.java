package us.core.pr.domain.db.listeners.abstractions.interfaces;

public interface IEntityPostListener<E>
        extends IEntityListener<E>
{
    void load(E e);
}
