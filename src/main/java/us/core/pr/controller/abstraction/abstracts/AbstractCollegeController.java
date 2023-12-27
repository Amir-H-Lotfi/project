package us.core.pr.controller.abstraction.abstracts;

import us.core.pr.controller.abstraction.interfaces.ICrudController;
import us.core.pr.service.interfaces.ICollegeService;

public abstract class AbstractCollegeController
{
    protected final ICollegeService iCollegeService;

    protected AbstractCollegeController(ICollegeService iCollegeService)
    {
        this.iCollegeService = iCollegeService;
    }
}
