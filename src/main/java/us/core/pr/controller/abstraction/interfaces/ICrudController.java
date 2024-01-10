package us.core.pr.controller.abstraction.interfaces;

import java.io.Serializable;

public interface ICrudController<C, R, U, D, K>
        extends Serializable
{
    void put(C c);

    R get(K k);

    void patch(U u);

    void delete(D d);
}
