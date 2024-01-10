package us.core.pr.utils.mapper.factory.impl;

import us.core.pr.utils.mapper.abstractions.interfaces.IDataTransferObjectMapper;
import us.core.pr.utils.mapper.factory.abstractions.abstracts.AbstractDataTransferMapperFactory;

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
