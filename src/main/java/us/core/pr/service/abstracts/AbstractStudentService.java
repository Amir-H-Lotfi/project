package us.core.pr.service.abstracts;

import us.core.pr.domain.dto.StudentDTO;
import us.core.pr.repository.IStudentRepository;
import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.service.interfaces.ICrudService;
import us.core.pr.service.interfaces.IStudentService;


public abstract class AbstractStudentService
        implements IStudentService,
        ICrudService<StudentDTO.Create, StudentDTO.Read, StudentDTO.Update, StudentDTO.Delete, String>
{
    protected final IStudentRepository                                                                                isRepository;
    protected final ICrudOperations<StudentDTO.Create, StudentDTO.Read, StudentDTO.Update, StudentDTO.Delete, String> iCrudOperations;

    public AbstractStudentService(IStudentRepository isRepository,
            ICrudOperations<StudentDTO.Create, StudentDTO.Read, StudentDTO.Update, StudentDTO.Delete, String> iCrudOperations)
    {
        this.isRepository = isRepository;
        this.iCrudOperations = iCrudOperations;
    }

}
