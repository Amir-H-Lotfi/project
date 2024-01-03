package us.core.pr.controller.abstraction.interfaces;

import java.io.Serializable;

public interface ICrudController<C, R, U, D, K>
        extends Serializable
{
    void create(C c);

    R read(K k);

    void update(U u);

    void delete(D d);
}
