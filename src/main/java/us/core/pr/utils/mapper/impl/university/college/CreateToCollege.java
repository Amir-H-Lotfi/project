package us.core.pr.utils.mapper.impl.university.college;

import us.core.pr.domain.db.entities.university.College;
import us.core.pr.domain.db.entities.university.Course;
import us.core.pr.domain.db.entities.university.Professor;
import us.core.pr.domain.db.entities.university.Student;
import us.core.pr.domain.dto.college.Create;
import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.university.course.ReadToCourse;
import us.core.pr.utils.mapper.impl.university.professor.ReadToProfessor;
import us.core.pr.utils.mapper.impl.university.student.ReadToStudent;

public class CreateToCollege
        implements IDataTransferObjectMapper<Create, College>
{
    IDataTransferObjectMapperFactory factory;

    @Override
    public College from(Create source)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.professor.Read, Professor> rpMapper = factory.create(ReadToProfessor.class);
        IDataTransferObjectMapper<us.core.pr.domain.dto.student.Read, Student> rsMapper = factory.create(ReadToStudent.class);
        IDataTransferObjectMapper<us.core.pr.domain.dto.course.Read, Course> rcMapper = factory.create(ReadToCourse.class);


        return new GenericBeanBuilder<>(College.class)
                .with("name", source.getName())
                .with("headOfDepartment", rpMapper.from(source.getHeadOfDepartment()))
                .with("professors", rpMapper.from(source.getProfessors()))
                .with("students", rsMapper.from(source.getStudents()))
                .with("courses", rcMapper.from(source.getCourses()))
                .build();
    }

    public void setFactory(IDataTransferObjectMapperFactory factory)
    {
        this.factory = factory;
    }
}
