package us.core.pr.utils.mapper.impl.professor;

import us.core.pr.utils.mapper.abstractions.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.professor.*;
import us.core.pr.domain.entity.Professor;

public class CreateToProfessor
        implements IDataTransferObjectMapper<Create, Professor>
{
    @Override
    public Professor from(Create source)
    {
        return null;
    }
}
