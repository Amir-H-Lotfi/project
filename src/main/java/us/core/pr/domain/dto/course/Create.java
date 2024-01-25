package us.core.pr.domain.dto.course;

import us.core.pr.domain.dto.base.BaseDTO;

import java.io.Serializable;
import java.util.*;

public class Create
        extends BaseDTO
        implements Serializable
{
    private String                                                name;
    private Integer                                            credit;
    private Set<us.core.pr.domain.dto.mdt.coursetaught.Create> courseTaught;
    private Set<us.core.pr.domain.dto.mdt.coursetaken.Create>  courseTaken;


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

    public Integer getCredit()
    {
        return credit;
    }

    public void setCredit(Integer credit)
    {
        this.credit = credit;
    }
}
