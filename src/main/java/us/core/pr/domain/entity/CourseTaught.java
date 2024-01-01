package us.core.pr.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CourseTaught
{
    @Embeddable
    public static class CompositeKey
            implements Serializable
    {
        private String courseId;
        private String professorId;

        @Column(name = "course_name")
        public String getCourseId()
        {
            return courseId;
        }

        public void setCourseId(String course)
        {
            this.courseId = course;
        }

        @Column(name = "professor_id")
        public String getProfessorId()
        {
            return professorId;
        }

        public void setProfessorId(String professor)
        {
            this.professorId = professor;
        }
    }

    private CompositeKey compositeKey;
    private Professor    professor;
    private Course       course;

    public CourseTaught()
    {
    }

    public CourseTaught(Professor professor, Course course)
    {
        this.professor = professor;
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

    @ManyToOne
    @MapsId("professorId")
    @JoinColumn(name = "professor_id")
    public Professor getProfessor()
    {
        return professor;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }
}
