package us.core.pr.service.abstraction;


import org.springframework.data.jpa.repository.JpaRepository;
import us.core.pr.domain.db.entities.base.BaseEntity;
import us.core.pr.error.exception.service.crud.RecordCreatingFailureException;
import us.core.pr.error.exception.service.crud.RecordDeletingFailureException;
import us.core.pr.error.exception.service.crud.RecordReadingFailureException;
import us.core.pr.error.exception.service.crud.RecordUpdatingFailureException;
import us.core.pr.error.exception.entity.RecordNotFoundException;
import us.core.pr.service.abstraction.interfaces.IGenericJpaService;

public abstract class AbstractGenericJpaService<E extends BaseEntity, K extends Object, R extends JpaRepository<E, K>>
        implements IGenericJpaService<E, K>
{

    protected R repository;

    public AbstractGenericJpaService(R repository)
    {
        this.repository = repository;
    }

    @Override
    public E create(E entity)
    {
        try
        {
            repository.saveAndFlush(entity);
            return entity;
        }
        catch (IllegalArgumentException e)
        {
            throw new RecordCreatingFailureException(e);
        }
    }

    @Override
    public E read(K key)
    {
        E entity;
        try
        {
            entity = repository.findById(key).orElseThrow(RecordNotFoundException::new);
            return entity;
        }
        catch (IllegalArgumentException | RecordNotFoundException e)
        {
            throw new RecordReadingFailureException(e);
        }
    }

    @Override
    public E update(K key, E entity)
    {
        try
        {
            if (repository.existsById(key))
            {
                repository.saveAndFlush(entity);
            }
            else throw new RecordNotFoundException();
            return entity;
        }
        catch (IllegalArgumentException | RecordNotFoundException e)
        {
            throw new RecordUpdatingFailureException(e);
        }
    }

    @Override
    public E delete(K key)
    {
        E entity;
        try
        {
            entity = repository.findById(key).orElseThrow(RecordNotFoundException::new);
            repository.deleteById(key);
            return entity;
        }
        catch (IllegalArgumentException | RecordNotFoundException e)
        {
            throw new RecordDeletingFailureException(e);
        }
    }
}
