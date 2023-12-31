package us.core.pr.domain.entity;

import us.core.pr.domain.entity.constraints.CollegeName;
import us.core.pr.domain.entity.listener.impl.EveryEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@EntityListeners(value = {
        EveryEntityListener.PreEveryEntityListener.class,
        EveryEntityListener.PostEveryEntityListener.class
})
@Entity
public class College
        implements Serializable
{
    private String name;

    /**
     * relationships
     */

    private Professor      headOfDepartment;
    private Set<Course>    courses;
    private Set<Student>   students;
    private Set<Professor> professors;

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
    public Set<Course> getCourses()
    {
        return courses;
    }

    @OneToMany
    @JoinColumn(name = "college_name")
    public Set<Student> getStudents()
    {
        return students;
    }

    @OneToMany
    @JoinColumn(name = "college_name")
    public Set<Professor> getProfessors()
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
        headOfDepartment.setDepartment(this);
    }

    public void setCourses(Set<Course> courses)
    {
        this.courses = courses;
    }

    public void setStudents(Set<Student> students)
    {
        this.students = students;
    }

    public void setProfessors(Set<Professor> professors)
    {
        this.professors = professors;
    }

    public void addCourse(Course course)
    {
        if (this.courses == null)
        {
            this.courses = new HashSet<>();
        }
        this.courses.add(course);
    }

    public void addStudent(Student student)
    {
        if (this.students == null)
        {
            this.students = new HashSet<>();
        }
        this.students.add(student);
    }

    public void addProfessor(Professor professor)
    {
        if (this.professors == null)
        {
            this.professors = new HashSet<>();
        }
        this.professors.add(professor);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        College college = (College) o;
        return college.name.equals(this.name);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }
}

