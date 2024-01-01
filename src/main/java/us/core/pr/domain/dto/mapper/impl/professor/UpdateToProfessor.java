package us.core.pr.domain.dto.mapper.impl.professor;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.professor.Update;
import us.core.pr.domain.entity.Professor;

public class UpdateToProfessor
        implements IDataTransferObjectMapper<Update, Professor>
{
    @Override
    public Professor from(Update source)
    {
        return null;
    }
}
