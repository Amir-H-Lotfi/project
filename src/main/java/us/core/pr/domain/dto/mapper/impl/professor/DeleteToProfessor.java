package us.core.pr.domain.dto.mapper.impl.professor;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Professor;

import us.core.pr.domain.dto.professor.*;

public class DeleteToProfessor
        implements IDataTransferObjectMapper<Delete, Professor>
{
    @Override
    public Professor from(Delete source)
    {
        return null;
    }
}
