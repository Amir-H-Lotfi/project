package us.core.pr.domain.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CourseTaken
        implements Serializable
{
    @Embeddable
    public static class CompositeKey
            implements Serializable
    {
        private String courseId;
        private String studentId;


        @Column(name = "course_name")
        public String getCourseId()
        {
            return courseId;
        }

        public void setCourseId(String courseName)
        {
            this.courseId = courseName;
        }

        @Column(name = "student_id")
        public String getStudentId()
        {
            return studentId;
        }

        public void setStudentId(String studentId)
        {
            this.studentId = studentId;
        }
    }

    private CompositeKey compositeKey;
    private Integer      grade;
    private Student      student;
    private Course       course;

    public CourseTaken() {}

    public CourseTaken(Integer grade, Student student, Course course)
    {
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    @EmbeddedId
    public CompositeKey getCompositeKey()
    {
        return compositeKey;
    }

    public void setCompositeKey(CompositeKey compositeKey)
    {
        this.compositeKey = compositeKey;
    }

    public Integer getGrade()
    {
        return grade;
    }

    public void setGrade(Integer grade)
    {
        this.grade = grade;
    }

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_name")
    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }
}
