package us.core.pr.domain.dto.mapper.factory.interfaces;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;

import java.io.Serializable;

public interface IDataTransferObjectMapperFactory
        extends Serializable
{
    <T, R> IDataTransferObjectMapper<T, R> create(Class<? extends IDataTransferObjectMapper<T, R>> mapper)
            throws IllegalAccessException, InstantiationException;
}
