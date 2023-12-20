package us.core.pr.controller.abstraction;

import java.io.Serial;
import java.io.Serializable;

public interface CrudController<T>
        extends Serializable
{
    void create(T t);

    void read(T t);

    void update(T t);

    void remove(T t);
}
