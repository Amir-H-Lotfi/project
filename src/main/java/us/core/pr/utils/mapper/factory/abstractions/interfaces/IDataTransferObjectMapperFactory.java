package us.core.pr.utils.mapper.factory.abstractions.interfaces;

import us.core.pr.error.exception.mapper.MapperNotFoundException;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;

import java.io.Serializable;

public interface IDataTransferObjectMapperFactory
        extends Serializable
{
    <T, R> IDataTransferObjectMapper<T, R> create(Class<? extends IDataTransferObjectMapper<T, R>> mapper)
            throws MapperNotFoundException;
}
