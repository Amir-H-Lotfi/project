package us.core.pr.utils.mapper.impl.university.professor;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.dto.professor.*;
import us.core.pr.domain.db.entities.university.Professor;

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
