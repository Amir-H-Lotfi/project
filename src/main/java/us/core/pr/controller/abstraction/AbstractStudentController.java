package us.core.pr.controller.abstraction;

import us.core.pr.service.impl.StudentService;

import java.io.Serializable;

public abstract class AbstractStudentController
        implements Serializable
{

    protected StudentService service;

    protected AbstractStudentController(StudentService service)
    {
        this.service = service;
    }
}
