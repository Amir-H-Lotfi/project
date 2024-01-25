package us.core.pr.domain.dto.student;

import us.core.pr.domain.dto.mdt.coursetaken.Read;

import java.io.Serializable;
import java.util.*;

public class Create
        implements Serializable
{
    private String                                             studentId;
    private String                                             name;
    private String                                             surname;
    private String                                             nationalId;
    private String                                          address;
    private Set<us.core.pr.domain.dto.mdt.coursetaken.Read> courseTaken;

    public Create()
    {
    }

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Set<Read> getCourseTaken()
    {
        return courseTaken;
    }

    public void setCourseTaken(Set<Read> courseTaken)
    {
        this.courseTaken = courseTaken;
    }
}
