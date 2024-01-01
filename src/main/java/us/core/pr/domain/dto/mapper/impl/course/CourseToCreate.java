package us.core.pr.domain.dto.mapper.impl.course;

import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
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
