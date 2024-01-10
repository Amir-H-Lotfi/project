package us.core.pr.utils.mapper.abstractions.interfaces;

import java.io.Serializable;

public interface IDataTransferObjectMapper<A, B>
        extends Serializable
{
    B from(A source);
}
