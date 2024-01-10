package us.core.pr.utils.mapper.impl.course;

import us.core.pr.domain.dto.course.Create;
import us.core.pr.utils.mapper.abstractions.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Course;

import java.util.HashSet;

public class CreateToCourse
        implements IDataTransferObjectMapper<Create, Course>
{
    @Override
    public Course from(Create source)
    {
        Course course = new Course();

        course.setName(source.getName());
        course.setCredit(source.getCredit());
        course.setCourseTaken(new HashSet<>());
        course.setCourseTaught(new HashSet<>());

        return course;
    }
}
