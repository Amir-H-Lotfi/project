package us.core.pr.domain.dto.college;

import java.io.Serializable;
import java.math.BigDecimal;

public class Update
        implements Serializable
{
    private String name;

    public Update()
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
