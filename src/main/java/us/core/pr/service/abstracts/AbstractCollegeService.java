package us.core.pr.service.abstracts;

import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.service.interfaces.ICollegeService;
import us.core.pr.domain.dto.college.*;
import us.core.pr.service.interfaces.ICrudService;

public abstract class AbstractCollegeService
        implements ICollegeService, ICrudService<Create, Read, Update, Delete, String>
{
    protected final ICollegeRepository                                    icRepository;
    protected final ICrudOperations<Create, Read, Update, Delete, String> iCrudOperations;

    protected AbstractCollegeService(ICollegeRepository icRepository, ICrudOperations<Create, Read, Update, Delete, String> iCrudOperations)
    {
        this.icRepository = icRepository;
        this.iCrudOperations = iCrudOperations;
    }


}
