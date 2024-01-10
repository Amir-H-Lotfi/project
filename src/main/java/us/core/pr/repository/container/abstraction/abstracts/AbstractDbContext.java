package us.core.pr.repository.container.abstraction.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import us.core.pr.repository.container.abstraction.interfaces.IDbContext;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractDbContext
        implements IDbContext
{
    protected final List<JpaRepository> repositories = new LinkedList<>();

    public AbstractDbContext(JpaRepository... repository)
    {
        Collections.addAll(repositories, repository);
    }
}
