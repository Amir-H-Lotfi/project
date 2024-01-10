package us.core.pr.domain.crud.abstractions.abstracts;

import us.core.pr.domain.crud.abstractions.interfaces.ICrudOperations;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.domain.dto.college.*;

public abstract class AbstractCollegeJpaCrud
        implements ICrudOperations<Create, Read, Update, Delete, String>
{
    protected final ICollegeRepository iCollegeRepository;

    public AbstractCollegeJpaCrud(ICollegeRepository iCollegeRepository)
    {
        this.iCollegeRepository = iCollegeRepository;
    }
}
