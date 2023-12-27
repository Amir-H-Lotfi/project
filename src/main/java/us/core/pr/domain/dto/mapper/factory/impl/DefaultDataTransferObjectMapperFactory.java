package us.core.pr.domain.dto.mapper.factory.impl;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.mapper.factory.abstracts.AbstractDataTransferMapperFactory;

public class DefaultDataTransferObjectMapperFactory
        extends AbstractDataTransferMapperFactory
{
    public DefaultDataTransferObjectMapperFactory() {super();}

    @Override
    public <T, R> IDataTransferObjectMapper<T, R> create(Class<? extends IDataTransferObjectMapper<T, R>> mapper)
            throws IllegalAccessException, InstantiationException
    {
        return mapper.newInstance();
    }

}
