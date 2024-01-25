package us.core.pr.domain.dto.mdt.coursetaught;

import java.io.Serializable;

public class Update
        implements Serializable
{
    private us.core.pr.domain.dto.professor.Update professor;
    private us.core.pr.domain.dto.course.Update    course;

    public us.core.pr.domain.dto.professor.Update getProfessor()
    {
        return professor;
    }

    public void setProfessor(us.core.pr.domain.dto.professor.Update professor)
    {
        this.professor = professor;
    }

    public us.core.pr.domain.dto.course.Update getCourse()
    {
        return course;
    }

    public void setCourse(us.core.pr.domain.dto.course.Update course)
    {
        this.course = course;
    }
}
