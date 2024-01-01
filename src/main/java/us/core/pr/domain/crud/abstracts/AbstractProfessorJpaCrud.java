package us.core.pr.domain.crud.abstracts;

import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.domain.dto.professor.*;

public abstract class AbstractProfessorJpaCrud
        implements ICrudOperations<Create, Read, Update, Delete, String>
{
    protected final IProfessorRepository ipRepository;

    protected AbstractProfessorJpaCrud(IProfessorRepository ipRepository)
    {
        this.ipRepository = ipRepository;
    }
}
