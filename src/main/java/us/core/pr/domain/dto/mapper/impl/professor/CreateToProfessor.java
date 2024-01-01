package us.core.pr.domain.dto.mapper.impl.professor;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
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
