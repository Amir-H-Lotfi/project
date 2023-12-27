package us.core.pr.domain.crud.interfaces;

import java.io.Serializable;

public interface ICrudOperations<C, R, U, D, K>
        extends Serializable
{
    void create(C c);

    R read(K key);

    void update(U u);

    void delete(D d);
}
