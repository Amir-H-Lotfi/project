package us.core.pr.controller.abstraction.abstracts;

import us.core.pr.controller.abstraction.interfaces.ICrudController;
import us.core.pr.service.abstraction.abstracts.AbstractCollegeService;
import us.core.pr.domain.dto.college.*;

public abstract class AbstractCollegeController
        implements ICrudController<Create, Read, Update, Delete, String>
{
    protected final AbstractCollegeService iCollegeService;

    protected AbstractCollegeController(AbstractCollegeService iCollegeService)
    {
        this.iCollegeService = iCollegeService;
    }

    @Override
    public void put(Create create)
    {
        iCollegeService.createEntity(create);
    }

    @Override
    public Read get(String s)
    {
        return iCollegeService.readEntity(s);
    }

    @Override
    public void patch(Update update)
    {
        iCollegeService.updateEntity(update);
    }

    @Override
    public void delete(Delete delete)
    {
        iCollegeService.deleteEntity(delete);
    }
}
