package us.core.pr.domain.dto.professor;

import java.io.Serializable;

public class Read
        implements Serializable
{
    private String personnelId;
    private String name;

    public Read() {

    }

    public String getPersonnelId()
    {
        return personnelId;
    }

    public void setPersonnelId(String personnelId)
    {
        this.personnelId = personnelId;
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
