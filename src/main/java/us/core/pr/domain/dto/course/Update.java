package us.core.pr.domain.dto.course;

import java.io.Serializable;
import java.util.*;

public class Update
        implements Serializable
{
    private String                                              name;
    private Integer                                            credit;
    private Set<us.core.pr.domain.dto.mdt.coursetaught.Update> courseTaught;
    private Set<us.core.pr.domain.dto.mdt.coursetaken.Update>  courseTaken;

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

    public Set<us.core.pr.domain.dto.mdt.coursetaught.Update> getCourseTaught()
    {
        return courseTaught;
    }

    public void setCourseTaught(Set<us.core.pr.domain.dto.mdt.coursetaught.Update> courseTaught)
    {
        this.courseTaught = courseTaught;
    }

    public Set<us.core.pr.domain.dto.mdt.coursetaken.Update> getCourseTaken()
    {
        return courseTaken;
    }

    public void setCourseTaken(Set<us.core.pr.domain.dto.mdt.coursetaken.Update> courseTaken)
    {
        this.courseTaken = courseTaken;
    }
}
