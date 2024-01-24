package us.core.pr.utils.mapper.impl.university.professor;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.dto.professor.Update;
import us.core.pr.domain.db.entities.university.Professor;

public class UpdateToProfessor
        implements IDataTransferObjectMapper<Update, Professor>
{
    @Override
    public Professor from(Update source)
    {
        return new GenericBeanBuilder<>(Professor.class)
                .with("personnelId", source.getPersonnelId())
                .build();
    }
}
