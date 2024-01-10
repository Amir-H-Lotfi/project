package us.core.pr.domain.entity.listener.abstractions.interfaces;

public interface IEntityPostListener<E>
        extends IEntityListener<E>
{
    void load(E e);
}
