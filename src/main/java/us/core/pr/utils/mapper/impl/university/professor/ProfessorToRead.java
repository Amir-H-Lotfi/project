package us.core.pr.utils.mapper.impl.university.professor;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.db.entities.university.Professor;

import us.core.pr.domain.dto.professor.*;

public class ProfessorToRead
        implements IDataTransferObjectMapper<Professor, Read>
{
    @Override
    public Read from(Professor source)
    {
        return new GenericBeanBuilder<>(Read.class)
                .with("name", source.getName())
                .with("personnelId", source.getPersonnelId())
                .build();
    }
}
