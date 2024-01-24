package us.core.pr.domain.dto.middle.coursetaught;

import us.core.pr.domain.dto.professor.Read;

import java.io.Serializable;

public class Create
        implements Serializable
{
    private Integer                                courseId;
    private Integer                                professorId;
    private us.core.pr.domain.dto.professor.Create professor;
    private us.core.pr.domain.dto.course.Create    course;

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

    public us.core.pr.domain.dto.professor.Create getProfessor()
    {
        return professor;
    }

    public void setProfessor(us.core.pr.domain.dto.professor.Create professor)
    {
        this.professor = professor;
    }

    public us.core.pr.domain.dto.course.Create getCourse()
    {
        return course;
    }

    public void setCourse(us.core.pr.domain.dto.course.Create course)
    {
        this.course = course;
    }
}
