package us.core.pr.domain.entity.listener.interfaces;

public interface IEntityPostListener<E>
        extends IEntityListener<E>
{
    void load(E e);
}
