package us.core.pr.controller.abstraction;


import us.core.pr.service.impl.CollegeService;

import java.io.Serializable;

public abstract class AbstractCollegeController
    implements Serializable

{
    protected CollegeService service;

    protected AbstractCollegeController(CollegeService service)
    {
        this.service = service;
    }

}
