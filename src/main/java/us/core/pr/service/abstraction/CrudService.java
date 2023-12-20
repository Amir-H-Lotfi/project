package us.core.pr.service.abstraction;

import java.io.Serializable;

public interface CrudService<T>
        extends Serializable
{
    void create(T t);

    void read(T t);

    void update(T t);

    void delete(T t);
}
