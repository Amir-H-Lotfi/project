package us.core.pr.utils.mapper.impl.university.student;

import us.core.pr.domain.db.entities.university.Student;
import us.core.pr.domain.dto.student.Read;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;

public class ReadToStudent
    implements IDataTransferObjectMapper<Read, Student>
{
    @Override
    public Student from(Read source)
    {
        return null;
    }
}
