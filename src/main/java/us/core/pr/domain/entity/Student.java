package us.core.pr.domain.entity;

import us.core.pr.domain.entity.constraints.Address;
import us.core.pr.domain.entity.constraints.PersonName;
import us.core.pr.domain.entity.listener.impl.EveryEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@EntityListeners(value = {
        EveryEntityListener.PreEveryEntityListener.class,
        EveryEntityListener.PostEveryEntityListener.class
})
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
    private Set<CourseTaken> courseTaken;

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

    @OneToMany(mappedBy = "course")
    public Set<CourseTaken> getCourseTaken()
    {
        return courseTaken;
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

    public void setCourseTaken(Set<CourseTaken> courses)
    {
        this.courseTaken = courses;
    }
}