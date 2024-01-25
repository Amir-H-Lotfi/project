package us.core.pr.utils.mapper.abstractions;

import java.io.Serializable;
import java.util.*;

public interface IDataTransferObjectMapper<A, B>
        extends Serializable
{
    B from(A source);

    default Set<B> from(Set<A> sources)
    {
        Iterator<A> sourceIterator = sources.iterator();
        Set<B> bSet = new HashSet<>();
        while (sourceIterator.hasNext())
        {
            A a = sourceIterator.next();
            bSet.add(this.from(a));
        }
        return bSet;
    }

}
