package us.core.pr.utils.mapper.impl.university.course;

import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.db.entities.university.Course;
import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;

public class CourseToCreate
        implements IDataTransferObjectMapper<Course, Create>
{
    @Override
    public Create from(Course source)
    {
        return new GenericBeanBuilder<>(Create.class)
                .with("name", source.getName())
                .with("credit", source.getCredit())
                .build();
    }
}
