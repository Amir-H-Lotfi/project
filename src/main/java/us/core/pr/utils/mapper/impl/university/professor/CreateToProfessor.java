package us.core.pr.utils.mapper.impl.university.professor;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.dto.professor.*;
import us.core.pr.domain.db.entities.university.Professor;

public class CreateToProfessor
        implements IDataTransferObjectMapper<Create, Professor>
{
    @Override
    public Professor from(Create source)
    {
        return new GenericBeanBuilder<>(Professor.class)
                .with("name", source.getName())
                .with("surname", source.getSurname())
                .with("personnelId", source.getPersonnelId())
                .with("nationalId", source.getNationalId())
                .build();
    }
}
