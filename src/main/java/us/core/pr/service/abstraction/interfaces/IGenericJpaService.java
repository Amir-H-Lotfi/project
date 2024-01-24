package us.core.pr.service.abstraction.interfaces;

import us.core.pr.domain.db.entities.base.BaseEntity;

import java.io.Serializable;

public interface IGenericJpaService<E extends BaseEntity, K extends Object>
        extends Serializable
{
    E create(E entity);

    E read(K key);

    E update(K key, E entity);

    E delete(K key);

}
