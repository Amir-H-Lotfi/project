package us.core.pr.domain.dto.mapper.impl.student;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Student;

import us.core.pr.domain.dto.student.*;

public class StudentToRead
        implements IDataTransferObjectMapper<Student, Read>
{
    @Override
    public Read from(Student source)
    {
        return null;
    }
}
