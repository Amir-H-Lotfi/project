package us.core.pr.utils.mapper.impl.college;

import us.core.pr.utils.mapper.abstractions.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;
import us.core.pr.domain.dto.college.*;

public class CollegeToRead
        implements IDataTransferObjectMapper<College, Read>
{
    @Override
    public Read from(College source)
    {
        return null;

    }
}
