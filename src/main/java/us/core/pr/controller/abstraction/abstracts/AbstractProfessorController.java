package us.core.pr.controller.abstraction.abstracts;

import us.core.pr.controller.abstraction.interfaces.ICrudController;
import us.core.pr.service.interfaces.IProfessorService;

public abstract class AbstractProfessorController
{
    protected final IProfessorService iProfessorService;

    protected AbstractProfessorController(IProfessorService iProfessorService)
    {
        this.iProfessorService = iProfessorService;
    }
}
