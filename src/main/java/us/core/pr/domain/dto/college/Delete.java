package us.core.pr.domain.dto.college;

import java.io.Serializable;

public class Delete
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
