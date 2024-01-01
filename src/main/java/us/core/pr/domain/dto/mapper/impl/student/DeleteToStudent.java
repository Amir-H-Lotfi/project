package us.core.pr.domain.dto.mapper.impl.student;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Student;

import us.core.pr.domain.dto.student.*;

public class DeleteToStudent
        implements IDataTransferObjectMapper<Delete, Student>
{
    @Override
    public Student from(Delete source)
    {
        return null;
    }
}
