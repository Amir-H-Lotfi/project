package us.core.pr.domain.dto.mdt.coursetaught;

import us.core.pr.domain.dto.professor.Read;

import java.io.Serializable;

public class Create
        implements Serializable
{
    private Integer                              courseId;
    private Integer                              professorId;
    private us.core.pr.domain.dto.professor.Read professor;
    private us.core.pr.domain.dto.course.Read    course;

    public Integer getCourseId()
    {
        return courseId;
    }

    public void setCourseId(Integer courseId)
    {
        this.courseId = courseId;
    }

    public Integer getProfessorId()
    {
        return professorId;
    }

    public void setProfessorId(Integer professorId)
    {
        this.professorId = professorId;
    }

    public Read getProfessor()
    {
        return professor;
    }

    public void setProfessor(Read professor)
    {
        this.professor = professor;
    }

    public us.core.pr.domain.dto.course.Read getCourse()
    {
        return course;
    }

    public void setCourse(us.core.pr.domain.dto.course.Read course)
    {
        this.course = course;
    }
}
