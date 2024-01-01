package us.core.pr.domain.dto.mapper.impl.student;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.student.*;
import us.core.pr.domain.entity.Student;

public class CreateToStudent
    implements IDataTransferObjectMapper<Create , Student>
{
    @Override
    public Student from(Create source)
    {
        return null;
    }
}
