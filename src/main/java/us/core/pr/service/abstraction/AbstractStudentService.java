package us.core.pr.service.abstraction;

import us.core.pr.repository.ISRepository;

public abstract class AbstractStudentService
        implements ISService
{
    protected final ISRepository isRepository;

    public AbstractStudentService(ISRepository isRepository)
    {
        this.isRepository = isRepository;
    }

    public abstract void addCourse();

    // get a college's students averages
    public abstract void getAverage1();

    // get a specific student average
    public abstract void getAverage2();

    // get a professor's student average, group by lessons
    public abstract void getAverage3();

}
