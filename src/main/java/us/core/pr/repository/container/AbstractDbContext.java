package us.core.pr.repository.container;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractDbContext
        implements IDbContext
{
    protected final List<? super JpaRepository<? extends Object, ? extends Object>> repositories = new LinkedList<>();

    @SafeVarargs
    public AbstractDbContext(JpaRepository<? extends Object, ? extends Object>... repositories)
    {
        Collections.addAll(this.repositories, repositories);
    }
}
