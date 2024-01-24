package us.core.pr.utils.mapper.abstractions;

import java.io.Serializable;
import java.util.*;
import java.util.stream.*;

public interface IDataTransferObjectMapper<A, B>
        extends Serializable
{
    B from(A source);

    default Set<B> from(Set<A> sources)
    {
        return sources.stream().map(this::from).collect(Collectors.toSet());
    }

}
