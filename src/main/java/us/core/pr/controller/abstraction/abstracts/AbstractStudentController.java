package us.core.pr.controller.abstraction.abstracts;

import us.core.pr.service.interfaces.IStudentService;

public abstract class AbstractStudentController
{
    protected final IStudentService iStudentService;

    public AbstractStudentController(IStudentService iStudentService)
    {
        this.iStudentService = iStudentService;
    }
}
