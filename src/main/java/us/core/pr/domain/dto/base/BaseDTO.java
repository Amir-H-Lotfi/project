package us.core.pr.domain.dto.base;

import java.io.Serializable;

public class BaseDTO
        implements Serializable
{
    protected Integer id;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}
