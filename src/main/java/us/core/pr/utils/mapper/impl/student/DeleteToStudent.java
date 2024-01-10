package us.core.pr.utils.mapper.impl.student;

import us.core.pr.utils.mapper.abstractions.interfaces.IDataTransferObjectMapper;
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
