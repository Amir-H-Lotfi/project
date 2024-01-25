package us.core.pr.domain.dto.professor;

import us.core.pr.domain.dto.base.BaseDTO;

import java.io.Serializable;

public class Delete
        extends BaseDTO
        implements Serializable
{
    private String personnelId;
    private String name;

    public Delete()
    {

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
