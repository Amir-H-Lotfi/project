package us.core.pr.utils.mapper.impl.university.student;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.dto.student.*;
import us.core.pr.domain.db.entities.university.Student;

public class UpdateToStudent
        implements IDataTransferObjectMapper<Update, Student>
{
    @Override
    public Student from(Update source)
    {
        return new GenericBeanBuilder<>(Student.class)
                .with("studentId", source.getStudentId())
                .build();
    }
}
