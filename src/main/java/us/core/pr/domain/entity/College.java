package us.core.pr.domain.entity;

import jakarta.persistence.*;
import us.core.pr.domain.entity.constraints.CollegeName;
import us.core.pr.domain.entity.logger.abstraction.AbstractEntityListener;
import us.core.pr.domain.entity.logger.impl.CollegeEntityListener;

import java.io.Serializable;
import java.util.List;

@Entity
public class College
        implements Serializable
{
    private String name;

    /**
     * relationships
     */

    private Professor headOfDepartment;

    private List<Course> courses;
    private List<Student> students;
    private List<Professor> professors;

    public College() {}

    @Id
    @Column(length = 48)
    @CollegeName
    public String getName()
    {
        return name;
    }

    @OneToOne(mappedBy = "department")
    public Professor getHeadOfDepartment()
    {
        return headOfDepartment;
    }

    @OneToMany
    @JoinColumn(name = "college_name")
    public List<Course> getCourses()
    {
        return courses;
    }

    @OneToMany
    @JoinColumn(name = "college_name")
    public List<Student> getStudents()
    {
        return students;
    }

    @OneToMany
    @JoinColumn(name = "college_name")
    public List<Professor> getProfessors()
    {
        return professors;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setHeadOfDepartment(Professor headOfDepartment)
    {
        this.headOfDepartment = headOfDepartment;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public void setProfessors(List<Professor> professors)
    {
        this.professors = professors;
    }

}

