package us.core.pr.domain.dto.course;

import java.io.Serializable;

public class Create
implements Serializable
{
    private String name;
    private Integer credit;

    public Create() {

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
