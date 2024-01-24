package us.core.pr.domain.dto.student;

import us.core.pr.domain.dto.BaseDTO;

import java.io.Serializable;


public class Update
        extends BaseDTO
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
