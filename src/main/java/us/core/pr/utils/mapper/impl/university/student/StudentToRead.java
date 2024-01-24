package us.core.pr.utils.mapper.impl.university.student;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.db.entities.university.Student;

import us.core.pr.domain.dto.student.*;

public class StudentToRead
        implements IDataTransferObjectMapper<Student, Read>
{
    @Override
    public Read from(Student source)
    {
        return new GenericBeanBuilder<>(Read.class)
                .with("name", source.getName())
                .with("studentId", source.getStudentId())
                .build();
    }
}
