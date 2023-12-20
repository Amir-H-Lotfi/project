package us.core.pr.service.abstraction;

import us.core.pr.repository.ICRepository;

public abstract class AbstractCollegeService
        implements ICService
{
    protected final ICRepository icRepository;

    protected AbstractCollegeService(ICRepository icRepository)
    {
        this.icRepository = icRepository;
    }

    public abstract void addProfessor();

    public abstract void addHeadOfDepartment();

}
