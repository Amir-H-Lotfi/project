package us.core.pr.domain.entity;

import jakarta.persistence.*;
import us.core.pr.domain.entity.constraints.Address;
import us.core.pr.domain.entity.constraints.PersonName;
import us.core.pr.domain.entity.logger.impl.StudentEntityListener;

import java.io.Serializable;
import java.util.List;

@Entity
public class Student
        implements Serializable
{
    private String studentId;
    private String name;
    private String surname;
    private String nationalId;
    private String address;

    /**
     * relationships
     */
    private List<Course> courses;

    public Student() {}

    @Id
    public String getStudentId()
    {
        return studentId;
    }

    @Column(length = 48)
    @PersonName
    public String getName()
    {
        return name;
    }

    @Column(length = 48)
    @PersonName
    public String getSurname()
    {
        return surname;
    }

    @Column(length = 48)
    @PersonName
    public String getNationalId()
    {
        return nationalId;
    }

    @Column(length = 128)
    @Address
    public String getAddress()
    {
        return address;
    }

    @ManyToMany
    @JoinTable(name = "st_course_taken", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    public List<Course> getCourses()
    {
        return courses;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setNationalId(String nationalId)
    {
        this.nationalId = nationalId;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }
}