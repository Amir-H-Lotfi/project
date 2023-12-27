package us.core.pr.domain.crud.abstracts;

import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.service.interfaces.IProfessorService;

public abstract class AbstractProfessorJpaCrud
        implements ICrudOperations<ProfessorDTO.Create, ProfessorDTO.Read, ProfessorDTO.Update, ProfessorDTO.Delete, String>
{
    protected final IProfessorRepository ipRepository;

    protected AbstractProfessorJpaCrud(IProfessorRepository ipRepository)
    {
        this.ipRepository = ipRepository;
    }
}
