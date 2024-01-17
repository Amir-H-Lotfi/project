package us.core.pr.utils.mapper.impl.professor;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.dto.professor.*;
import us.core.pr.domain.entity.Professor;

public class ReadToProfessor
        implements IDataTransferObjectMapper<Read, Professor>
{
    @Override
    public Professor from(Read source)
    {
        return new GenericBeanBuilder<>(Professor.class)
                .with("name", source.getName())
                .with("personnelId", source.getPersonnelId())
                .build();
    }
}
