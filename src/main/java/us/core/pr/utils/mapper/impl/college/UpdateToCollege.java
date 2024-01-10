package us.core.pr.utils.mapper.impl.college;

import us.core.pr.utils.mapper.abstractions.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.college.*;
import us.core.pr.domain.entity.College;

public class UpdateToCollege
        implements IDataTransferObjectMapper<Update, College>
{
    @Override
    public College from(Update source)
    {
        return null;
    }
}
