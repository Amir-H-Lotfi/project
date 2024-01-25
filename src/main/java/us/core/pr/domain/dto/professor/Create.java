package us.core.pr.domain.dto.professor;

import us.core.pr.domain.dto.mdt.coursetaught.Read;

import java.io.Serializable;
import java.util.*;

public class Create
        implements Serializable
{
    private String                                              personnelId;
    private String                                              name;
    private String                                              surname;
    private String                                              nationalId;
    private us.core.pr.domain.dto.college.Read               department;
    private Set<us.core.pr.domain.dto.mdt.coursetaught.Read> courseTaught;

    public Create()
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

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getNationalId()
    {
        return nationalId;
    }

    public void setNationalId(String nationalId)
    {
        this.nationalId = nationalId;
    }

    public us.core.pr.domain.dto.college.Read getDepartment()
    {
        return department;
    }

    public void setDepartment(us.core.pr.domain.dto.college.Read department)
    {
        this.department = department;
    }

    public Set<Read> getCourseTaught()
    {
        return courseTaught;
    }

    public void setCourseTaught(Set<Read> courseTaught)
    {
        this.courseTaught = courseTaught;
    }
}
