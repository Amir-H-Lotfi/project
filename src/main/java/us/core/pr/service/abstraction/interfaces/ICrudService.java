package us.core.pr.service.abstraction.interfaces;

import java.io.Serializable;

public interface ICrudService<C, R, U, D, K>
        extends Serializable
{
    void createEntity(C entity);

    R readEntity(K key);

    void updateEntity(U entity);

    void deleteEntity(D entity);
}
