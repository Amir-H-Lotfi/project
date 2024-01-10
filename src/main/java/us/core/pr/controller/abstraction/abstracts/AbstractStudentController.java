package us.core.pr.controller.abstraction.abstracts;

import us.core.pr.controller.abstraction.interfaces.ICrudController;
import us.core.pr.service.abstraction.abstracts.AbstractStudentService;
import us.core.pr.domain.dto.student.*;

public abstract class AbstractStudentController
        implements ICrudController<Create, Read, Update, Delete, String>
{
    protected final AbstractStudentService iStudentService;

    public AbstractStudentController(AbstractStudentService iStudentService)
    {
        this.iStudentService = iStudentService;
    }

    @Override
    public void put(Create create)
    {
        iStudentService.createEntity(create);
    }

    @Override
    public Read get(String s)
    {
        return iStudentService.readEntity(s);
    }

    @Override
    public void patch(Update update)
    {
        iStudentService.updateEntity(update);
    }

    @Override
    public void delete(Delete delete)
    {
        iStudentService.deleteEntity(delete);
    }
}
