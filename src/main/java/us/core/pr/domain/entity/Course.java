package us.core.pr.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import us.core.pr.domain.entity.logger.impl.CourseEntityListener;

import java.io.Serializable;
import java.util.List;

@Entity
public class Course
        implements Serializable
{
    private String name;
    private Integer credit;


    /**
     * relationship
     */
    private List<Professor> professors;
    private List<Student> students;

    public Course() {}

    @Id
    @Column(length = 64)
    public String getName()
    {
        return name;
    }

    {
        this.name = name;
    }

    public Integer getCredit()
    {
        return credit;
    }

    {
        this.credit = credit;
    }

    @ManyToMany
    @JoinTable(name = "pr_course_taken", joinColumns = @JoinColumn(name = "course_id")
            , inverseJoinColumns = @JoinColumn(name = "professor_id"))
    public List<Professor> getProfessors()
    {
        return professors;
    }

    @ManyToMany(mappedBy = "courses")
    public List<Student> getStudents()
    {
        return students;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCredit(Integer credit)
    {
        this.credit = credit;
    }

    public void setProfessors(List<Professor> professors)
    {
        this.professors = professors;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

}
