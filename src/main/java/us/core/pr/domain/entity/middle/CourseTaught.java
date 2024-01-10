package us.core.pr.domain.entity.middle;

import us.core.pr.domain.entity.Course;
import us.core.pr.domain.entity.Professor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CourseTaught
{
    @Embeddable
    public static class CompositeKey
            implements Serializable
    {
        private Integer courseId;
        private Integer professorId;

        @Column(name = "course_id")
        public Integer getCourseId()
        {
            return courseId;
        }

        public void setCourseId(Integer course)
        {
            this.courseId = course;
        }

        @Column(name = "professor_id")
        public Integer getProfessorId()
        {
            return professorId;
        }

        public void setProfessorId(Integer professor)
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

    @ManyToOne(fetch = FetchType.LAZY)
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

    @ManyToOne(fetch = FetchType.LAZY)
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
