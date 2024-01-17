package us.core.pr.utils.mapper.impl.college;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;
import us.core.pr.domain.dto.college.*;

public class CreateToCollege
        implements IDataTransferObjectMapper<Create, College>
{
    @Override
    public College from(Create source)
    {
        return new GenericBeanBuilder<>(College.class).with("name", source.getName()).build();
    }
}
