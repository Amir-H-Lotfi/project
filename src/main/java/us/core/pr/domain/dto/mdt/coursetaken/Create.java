package us.core.pr.domain.dto.mdt.coursetaken;

import us.core.pr.domain.dto.student.Read;

import java.io.Serializable;

public class Create
        implements Serializable
{
    private Integer                            courseId;
    private Integer                            studentId;
    private Integer                            grade;
    private us.core.pr.domain.dto.student.Read student;
    private us.core.pr.domain.dto.course.Read  course;

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

    public Read getStudent()
    {
        return student;
    }

    public void setStudent(Read student)
    {
        this.student = student;
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