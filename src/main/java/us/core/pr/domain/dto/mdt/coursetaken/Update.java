package us.core.pr.domain.dto.mdt.coursetaken;

import java.io.Serializable;

public class Update
        implements Serializable
{
    private Integer                              grade;
    private us.core.pr.domain.dto.student.Update student;
    private us.core.pr.domain.dto.course.Update  course;

    public Integer getGrade()
    {
        return grade;
    }

    public void setGrade(Integer grade)
    {
        this.grade = grade;
    }

    public us.core.pr.domain.dto.student.Update getStudent()
    {
        return student;
    }

    public void setStudent(us.core.pr.domain.dto.student.Update student)
    {
        this.student = student;
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
