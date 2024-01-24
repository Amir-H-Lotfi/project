package us.core.pr.domain.dto.college;

import us.core.pr.domain.dto.BaseDTO;

import java.io.Serializable;

public class Read
        extends BaseDTO
        implements Serializable
{
    private String name;

    public Read()
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
