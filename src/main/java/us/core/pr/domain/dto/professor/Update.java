package us.core.pr.domain.dto.professor;

import us.core.pr.domain.dto.base.BaseDTO;

import java.io.Serializable;

public class Update
        extends BaseDTO
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
