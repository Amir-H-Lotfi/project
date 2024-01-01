package us.core.pr.domain.dto.student;

import java.io.Serializable;

public class Update
        implements Serializable
{
    private String studentId;

    public Update() {}

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
}
