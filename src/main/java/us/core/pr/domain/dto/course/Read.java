package us.core.pr.domain.dto.course;

import java.util.*;

public class Read
{
    private String  name;
    private Integer credit;

    private Set<us.core.pr.domain.dto.mdt.coursetaken.Read>  courseTaken;
    private Set<us.core.pr.domain.dto.mdt.coursetaught.Read> courseTaught;

    public Read()
    {
        courseTaken = new HashSet<>();
        courseTaken = new HashSet<>();
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

    public Set<us.core.pr.domain.dto.mdt.coursetaken.Read> getCourseTaken()
    {
        return courseTaken;
    }

    public void setCourseTaken(Set<us.core.pr.domain.dto.mdt.coursetaken.Read> courseTaken)
    {
        this.courseTaken = courseTaken;
    }

    public Set<us.core.pr.domain.dto.mdt.coursetaught.Read> getCourseTaught()
    {
        return courseTaught;
    }

    public void setCourseTaught(Set<us.core.pr.domain.dto.mdt.coursetaught.Read> courseTaught)
    {
        this.courseTaught = courseTaught;
    }

    public void addCourseTaken(us.core.pr.domain.dto.mdt.coursetaught.Read courseTaught)
    {
        this.courseTaught.add(courseTaught);
    }

    public void addCourseTaught(us.core.pr.domain.dto.mdt.coursetaken.Read courseTaken)
    {
        this.courseTaken.add(courseTaken);
    }
}
