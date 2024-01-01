package us.core.pr.domain.dto.professor;

import java.io.Serializable;

public class Update
        implements Serializable
{
    private String personnelId;

    public Update()
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
}
