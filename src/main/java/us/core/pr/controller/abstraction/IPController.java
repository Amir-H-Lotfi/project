package us.core.pr.controller.abstraction;

import us.core.pr.service.abstraction.IPService;

import java.io.Serializable;

public abstract class IPController<T>
        implements CrudController<T>
{
    protected final IPService ipService;

    protected IPController(IPService ipService)
    {
        this.ipService = ipService;
    }
}
