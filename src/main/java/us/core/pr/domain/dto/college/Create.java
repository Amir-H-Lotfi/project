package us.core.pr.domain.dto.college;

import java.io.Serializable;

public class Create
        implements Serializable
{
    private String name;

    public Create()
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
