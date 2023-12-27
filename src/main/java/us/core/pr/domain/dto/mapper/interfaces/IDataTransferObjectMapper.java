package us.core.pr.domain.dto.mapper.interfaces;

import java.io.Serializable;

public interface IDataTransferObjectMapper<A, B>
        extends Serializable
{
    B from(A source);
}
