package us.core.pr.service.abstracts;

import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.domain.entity.Professor;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.service.ProfessorService;
import us.core.pr.service.interfaces.ICrudService;
import us.core.pr.service.interfaces.IProfessorService;

public abstract class AbstractProfessorService
        implements IProfessorService,
        ICrudService<ProfessorDTO.Create, ProfessorDTO.Read, ProfessorDTO.Update, ProfessorDTO.Delete, String>
{
    protected final IProfessorRepository                                                                                      ipRepository;
    protected final ICrudOperations<ProfessorDTO.Create, ProfessorDTO.Read, ProfessorDTO.Update, ProfessorDTO.Delete, String> iCrudOperations;

    protected AbstractProfessorService(IProfessorRepository ipRepository,
            ICrudOperations<ProfessorDTO.Create, ProfessorDTO.Read, ProfessorDTO.Update, ProfessorDTO.Delete, String> iCrudOperations)
    {
        this.ipRepository = ipRepository;
        this.iCrudOperations = iCrudOperations;
    }

}
