package us.core.pr.service.abstracts;

import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.domain.dto.CollegeDTO;
import us.core.pr.domain.entity.College;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.service.interfaces.ICollegeService;
import us.core.pr.service.interfaces.ICrudService;

public abstract class AbstractCollegeService
        implements ICollegeService,
        ICrudService<CollegeDTO.Create, CollegeDTO.Read, CollegeDTO.Update, CollegeDTO.Delete, String>
{
    protected final ICollegeRepository                                                                                icRepository;
    protected final ICrudOperations<CollegeDTO.Create, CollegeDTO.Read, CollegeDTO.Update, CollegeDTO.Delete, String> iCrudOperations;

    protected AbstractCollegeService(ICollegeRepository icRepository,
            ICrudOperations<CollegeDTO.Create, CollegeDTO.Read, CollegeDTO.Update, CollegeDTO.Delete, String> iCrudOperations)
    {
        this.icRepository = icRepository;
        this.iCrudOperations = iCrudOperations;
    }


}
