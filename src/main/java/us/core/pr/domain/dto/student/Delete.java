package us.core.pr.domain.dto.student;

import java.io.Serializable;

public class Delete
        implements Serializable
{
    private String name;
    private String studentId;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
}
