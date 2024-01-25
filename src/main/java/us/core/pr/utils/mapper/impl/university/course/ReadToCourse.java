package us.core.pr.utils.mapper.impl.university.course;

import us.core.pr.domain.db.entities.university.College;
import us.core.pr.domain.db.entities.university.Course;
import us.core.pr.domain.dto.course.Read;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;

public class ReadToCourse
    implements IDataTransferObjectMapper<Read , Course>
{
    @Override
    public Course from(Read source)
    {
        return null;
    }
}
