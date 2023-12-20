package us.core.pr.controller.abstraction;

import us.core.pr.service.abstraction.ICService;

public abstract class ICController<T>
        implements CrudController<T>
{
    protected final ICService icService;

    protected ICController(ICService icService)
    {
        this.icService = icService;
    }
}
