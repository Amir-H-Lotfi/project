package us.core.pr.service.abstraction.abstracts;

import us.core.pr.repository.IStudentRepository;
import us.core.pr.domain.crud.abstractions.interfaces.ICrudOperations;
import us.core.pr.service.abstraction.interfaces.ICrudService;
import us.core.pr.service.abstraction.interfaces.IStudentService;
import us.core.pr.domain.dto.student.*;

public abstract class AbstractStudentService
        implements IStudentService,
        ICrudService<Create, Read, Update, Delete, String>
{
    protected final IStudentRepository                                    isRepository;
    protected final ICrudOperations<Create, Read, Update, Delete, String> iCrudOperations;

    public AbstractStudentService(IStudentRepository isRepository,
                                  ICrudOperations<Create, Read, Update, Delete, String> iCrudOperations)
    {
        this.isRepository = isRepository;
        this.iCrudOperations = iCrudOperations;
    }

}
