package us.core.pr.utils.mapper.impl.professor;

import us.core.pr.utils.mapper.abstractions.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Professor;

import us.core.pr.domain.dto.professor.*;

public class ProfessorToRead
        implements IDataTransferObjectMapper<Professor, Read>
{
    @Override
    public Read from(Professor source)
    {
        return null;
    }
}
