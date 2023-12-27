package us.core.pr.domain.crud.abstracts;

import us.core.pr.domain.dto.StudentDTO;
import us.core.pr.repository.IStudentRepository;
import us.core.pr.domain.crud.interfaces.ICrudOperations;

public abstract class AbstractStudentJpaCrud
        implements ICrudOperations<StudentDTO.Create, StudentDTO.Read, StudentDTO.Update, StudentDTO.Delete, String>
{
    protected final IStudentRepository isRepository;

    protected AbstractStudentJpaCrud(IStudentRepository isRepository)
    {
        this.isRepository = isRepository;
    }

}
