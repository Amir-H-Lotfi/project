package us.core.pr.utils.mapper.impl.course;

import us.core.pr.domain.dto.course.Create;
import us.core.pr.utils.mapper.abstractions.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.*;

public class CourseToCreate
        implements IDataTransferObjectMapper<Course, Create>
{
    @Override
    public Create from(Course source)
    {
        return null;
    }
}
