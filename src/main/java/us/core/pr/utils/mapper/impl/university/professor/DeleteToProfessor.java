package us.core.pr.utils.mapper.impl.university.professor;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.db.entities.university.Professor;

import us.core.pr.domain.dto.professor.*;

public class DeleteToProfessor
        implements IDataTransferObjectMapper<Delete, Professor>
{
    @Override
    public Professor from(Delete source)
    {
        return new GenericBeanBuilder<>(Professor.class)
                .with("name", source.getName())
                .with("personnelId", source.getPersonnelId())
                .build();
    }
}
