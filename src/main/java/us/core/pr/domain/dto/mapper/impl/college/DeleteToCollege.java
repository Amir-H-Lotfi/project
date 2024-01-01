package us.core.pr.domain.dto.mapper.impl.college;

import us.core.pr.domain.dto.college.*;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;

public class DeleteToCollege
implements IDataTransferObjectMapper<Delete , College>
{
    @Override
    public College from(Delete source)
    {
        return null;
    }
}
