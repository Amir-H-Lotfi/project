package us.core.pr.utils.mapper.impl.professor;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.dto.professor.Update;
import us.core.pr.domain.entity.Professor;

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
