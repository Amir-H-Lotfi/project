package us.core.pr.domain.dto.mapper.impl.professor;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.professor.*;
import us.core.pr.domain.entity.Professor;

public class ReadToProfessor
        implements IDataTransferObjectMapper<Read, Professor>
{
    @Override
    public Professor from(Read source)
    {
        Professor professor = new Professor();
        professor.setPersonnelId(source.getPersonnelId());
        professor.setName(source.getName()) ;
        return professor;
    }
}
