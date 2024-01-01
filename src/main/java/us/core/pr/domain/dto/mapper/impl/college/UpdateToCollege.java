package us.core.pr.domain.dto.mapper.impl.college;

import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
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
