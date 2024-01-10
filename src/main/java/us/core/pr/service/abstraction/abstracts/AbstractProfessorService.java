package us.core.pr.service.abstraction.abstracts;

import us.core.pr.domain.crud.abstractions.interfaces.ICrudOperations;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.service.abstraction.interfaces.ICrudService;
import us.core.pr.service.abstraction.interfaces.IProfessorService;
import us.core.pr.domain.dto.professor.*;

public abstract class AbstractProfessorService
        implements IProfessorService,
        ICrudService<Create, Read, Update, Delete, String>
{
    protected final IProfessorRepository                                  ipRepository;
    protected final ICrudOperations<Create, Read, Update, Delete, String> iCrudOperations;

    protected AbstractProfessorService(IProfessorRepository ipRepository,
                                       ICrudOperations<Create, Read, Update, Delete, String> iCrudOperations)
    {
        this.ipRepository = ipRepository;
        this.iCrudOperations = iCrudOperations;
    }

}
