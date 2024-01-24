package us.core.pr.domain.db.entities.university;

import us.core.pr.domain.db.entities.base.BaseEntity;
import us.core.pr.domain.db.listeners.impl.EveryEntityListener;
import us.core.pr.validation.annotation.CollegeName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@SequenceGenerator(name = "default_generator", sequenceName = "ent_college_seq", allocationSize = 1, initialValue = 1)
@EntityListeners(value = {
        EveryEntityListener.PreEveryEntityListener.class,
        EveryEntityListener.PostEveryEntityListener.class
})
@Table(name = "college",
        indexes = {
                @Index(columnList = "college_name", unique = true)
        })
@Entity
public class College
        extends BaseEntity
        implements Serializable
{
    private String name;

    private Professor      headOfDepartment;
    private Set<Course>    courses;
    private Set<Student>   students;
    private Set<Professor> professors;

    public College() {}

    @CollegeName(message = "Invalid College Name")
    @Column(name = "college_name", length = 48)
    public String getName()
    {
        return name;
    }

    @OneToOne(mappedBy = "department")
    public Professor getHeadOfDepartment()
    {
        return headOfDepartment;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_college_id")
    public Set<Course> getCourses()
    {
        return courses;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_college_id")
    public Set<Student> getStudents()
    {
        return students;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_college_id")
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

