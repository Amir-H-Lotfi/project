package us.core.pr.utils.mapper.impl.student;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Student;

import us.core.pr.domain.dto.student.*;

public class DeleteToStudent
        implements IDataTransferObjectMapper<Delete, Student>
{
    @Override
    public Student from(Delete source)
    {
        return new GenericBeanBuilder<>(Student.class)
                .with("name", source.getName())
                .with("studentId", source.getStudentId())
                .build();
    }
}
