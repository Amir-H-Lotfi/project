package us.core.pr.domain.crud.abstracts;

import us.core.pr.repository.IStudentRepository;
import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.domain.dto.student.*;

public abstract class AbstractStudentJpaCrud
        implements ICrudOperations<Create, Read, Update, Delete, String>
{
    protected final IStudentRepository isRepository;

    protected AbstractStudentJpaCrud(IStudentRepository isRepository)
    {
        this.isRepository = isRepository;
    }

}
