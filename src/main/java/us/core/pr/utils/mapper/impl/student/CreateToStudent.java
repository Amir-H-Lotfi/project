package us.core.pr.utils.mapper.impl.student;

import us.core.pr.utils.mapper.abstractions.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.student.*;
import us.core.pr.domain.entity.Student;

public class CreateToStudent
        implements IDataTransferObjectMapper<Create, Student>
{
    @Override
    public Student from(Create source)
    {
        return null;
    }
}
