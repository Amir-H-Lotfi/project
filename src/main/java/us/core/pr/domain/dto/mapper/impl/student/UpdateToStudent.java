package us.core.pr.domain.dto.mapper.impl.student;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.student.*;
import us.core.pr.domain.entity.Student;

public class UpdateToStudent
        implements IDataTransferObjectMapper<Update, Student>
{
    @Override
    public Student from(Update source)
    {
        return null;
    }
}
