package us.core.pr.repository.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.core.pr.exception.NoSuchRepositoryException;
import us.core.pr.repository.IPRepository;
import us.core.pr.repository.ISRepository;

@Component
public class DbContext
        extends AbstractDbContext
{

//    @Autowired
//    public DbContext(JpaRepository<Professor, String> ipRepository, JpaRepository<Student, String> isRepository)
//    {
//        super(ipRepository, isRepository);
//    }

    @Autowired
    public DbContext(IPRepository ipRepository, ISRepository isRepository)
    {
        super(ipRepository, isRepository);
    }

    @Override
    public <T> T getRepository(Class<T> t)
    {
        try
        {
            for (Object repository : super.repositories)
            {
                if (t.isInstance(repository))
                {
                    return (T) repository;
                }
            }
        }
        catch (RuntimeException ignored)
        {
        }
        finally
        {
            throw new NoSuchRepositoryException();
        }
    }
}
