package us.core.pr.repository.container.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import us.core.pr.exception.RepositoryNotFoundException;
import us.core.pr.repository.container.abstracts.AbstractDbContext;


public class DbContext
        extends AbstractDbContext
{

    @Override
    public <T> T getRepository(Class<T> t)
    {
        for (JpaRepository repository : super.repositories)
        {
            if (t.isInstance(repository))
            {
                return t.cast(repository);
            }
        }
        throw new RepositoryNotFoundException();
    }
}
