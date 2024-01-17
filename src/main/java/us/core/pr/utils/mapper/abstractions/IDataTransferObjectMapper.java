package us.core.pr.utils.mapper.abstractions;

import java.io.Serializable;

public interface IDataTransferObjectMapper<A, B>
        extends Serializable
{
    B from(A source);
}
