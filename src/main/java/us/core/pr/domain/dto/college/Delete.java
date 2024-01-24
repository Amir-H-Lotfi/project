package us.core.pr.domain.dto.college;

import us.core.pr.domain.dto.BaseDTO;

import java.io.Serializable;

public class Delete
        extends BaseDTO
        implements Serializable
{
    private String name;

    public Delete()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
