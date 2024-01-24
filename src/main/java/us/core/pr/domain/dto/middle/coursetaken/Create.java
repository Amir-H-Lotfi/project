package us.core.pr.domain.dto.middle.coursetaken;

import us.core.pr.domain.dto.student.Read;

import java.io.Serializable;

public class Create
        implements Serializable
{
    private Integer                            courseId;
    private Integer                            studentId;
    private Integer                            grade;
    private us.core.pr.domain.dto.student.Create student;
    private us.core.pr.domain.dto.course.Create course;

    public Integer getCourseId()
    {
        return courseId;
    }

    public void setCourseId(Integer courseId)
    {
        this.courseId = courseId;
    }

    public Integer getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }

    public Integer getGrade()
    {
        return grade;
    }

    public void setGrade(Integer grade)
    {
        this.grade = grade;
    }

    public us.core.pr.domain.dto.student.Create getStudent()
    {
        return student;
    }

    public void setStudent(us.core.pr.domain.dto.student.Create student)
    {
        this.student = student;
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
