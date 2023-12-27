package us.core.pr.domain.crud.abstracts;

import us.core.pr.domain.dto.CollegeDTO;
import us.core.pr.domain.entity.College;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.domain.crud.interfaces.ICrudOperations;

public abstract class AbstractCollegeJpaCrud
        implements ICrudOperations<CollegeDTO.Create , CollegeDTO.Read , CollegeDTO.Update, CollegeDTO.Delete,String>
{
    protected final ICollegeRepository iCollegeRepository;

    public AbstractCollegeJpaCrud(ICollegeRepository iCollegeRepository)
    {
        this.iCollegeRepository = iCollegeRepository;
    }
}
