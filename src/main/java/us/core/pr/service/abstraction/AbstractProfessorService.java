package us.core.pr.service.abstraction;

import us.core.pr.repository.IPRepository;

public abstract class AbstractProfessorService
        implements IPService
{
    private final IPRepository ipRepository;

    protected AbstractProfessorService(IPRepository ipRepository)
    {
        this.ipRepository = ipRepository;
    }

    public abstract void addCourse();

}
