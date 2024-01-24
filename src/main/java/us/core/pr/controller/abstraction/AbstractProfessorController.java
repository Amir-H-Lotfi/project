package us.core.pr.controller.abstraction;

import us.core.pr.service.impl.ProfessorService;

import java.io.Serializable;

public abstract class AbstractProfessorController implements Serializable
{
    protected ProfessorService service;

    protected AbstractProfessorController(ProfessorService service)
    {
        this.service = service;
    }
}
