package us.core.pr.controller.abstraction.interfaces;

import java.io.Serializable;

public interface ICrudController<T>
        extends Serializable
{
    void create(T t);

    void read(T t);

    void update(T t);
    void remove(T t);
}
