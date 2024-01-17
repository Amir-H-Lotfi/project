package us.core.pr.utils.mapper.impl.college;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;
import us.core.pr.domain.dto.college.*;

public class CollegeToRead
        implements IDataTransferObjectMapper<College, Read>
{
    @Override
    public Read from(College source)
    {
        return new GenericBeanBuilder<>(Read.class).with("name", source.getName()).build();
    }
}
