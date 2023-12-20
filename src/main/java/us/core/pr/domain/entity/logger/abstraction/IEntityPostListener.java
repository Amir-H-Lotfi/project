package us.core.pr.domain.entity.logger.abstraction;

public interface IEntityPostListener<E>
        extends IEntityListener<E>
{
    void load(E e);
}
