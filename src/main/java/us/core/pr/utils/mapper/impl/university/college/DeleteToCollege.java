package us.core.pr.utils.mapper.impl.university.college;

import us.core.pr.domain.dto.college.*;
import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.db.entities.university.College;

public class DeleteToCollege
        implements IDataTransferObjectMapper<Delete, College>
{
    @Override
    public College from(Delete source)
    {
        return new GenericBeanBuilder<>(College.class).with("name", source.getName()).build();
    }
}
