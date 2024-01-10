package us.core.pr.controller.abstraction.abstracts;

import us.core.pr.controller.abstraction.interfaces.ICrudController;
import us.core.pr.service.abstraction.abstracts.AbstractProfessorService;
import us.core.pr.domain.dto.professor.*;

public abstract class AbstractProfessorController
        implements ICrudController<Create, Read, Update, Delete, String>
{
    protected final AbstractProfessorService iProfessorService;

    protected AbstractProfessorController(AbstractProfessorService iProfessorService)
    {
        this.iProfessorService = iProfessorService;
    }

    @Override
    public void put(Create create)
    {
        iProfessorService.createEntity(create);
    }

    @Override
    public Read get(String s)
    {
        return iProfessorService.readEntity(s);
    }

    @Override
    public void patch(Update update)
    {
        iProfessorService.updateEntity(update);
    }

    @Override
    public void delete(Delete delete)
    {
        iProfessorService.deleteEntity(delete);
    }
}
