package us.core.pr.utils.mapper.impl.university.student;

import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.dto.student.*;
import us.core.pr.domain.db.entities.university.Student;

public class CreateToStudent
        implements IDataTransferObjectMapper<Create, Student>
{
    @Override
    public Student from(Create source)
    {
        return new GenericBeanBuilder<>(Student.class)
                .with("name", source.getName())
                .with("surname", source.getSurname())
                .with("studentId", source.getStudentId())
                .with("nationalId", source.getNationalId())
                .with("address", source.getAddress())
                .build();
    }
}
