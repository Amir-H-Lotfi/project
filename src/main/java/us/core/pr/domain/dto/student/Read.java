package us.core.pr.domain.dto.student;

import java.io.Serializable;

public class Read
        implements Serializable
{
    private String studentId;
    private String name;

    public Read() {}


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
}
