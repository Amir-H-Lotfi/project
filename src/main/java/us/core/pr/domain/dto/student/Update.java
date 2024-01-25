package us.core.pr.domain.dto.student;

import java.io.Serializable;
import java.util.*;


public class Update
        implements Serializable
{
    private String                                            studentId;
    private Set<us.core.pr.domain.dto.mdt.coursetaken.Update> courseTaken;

    public Update() {}

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
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
