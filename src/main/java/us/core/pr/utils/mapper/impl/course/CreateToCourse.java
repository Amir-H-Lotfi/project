package us.core.pr.utils.mapper.impl.course;

import us.core.pr.domain.dto.course.Create;
import us.core.pr.utils.builder.GenericBeanBuilder;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Course;

import java.util.HashSet;

public class CreateToCourse
        implements IDataTransferObjectMapper<Create, Course>
{
    @Override
    public Course from(Create source)
    {
        return new GenericBeanBuilder<>(Course.class)
                .with("name", source.getName())
                .with("credit", source.getCredit())
                .with("courseTaken", new HashSet<>())
                .with("courseTaught", new HashSet<>())
                .build();
    }
}
