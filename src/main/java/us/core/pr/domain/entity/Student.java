package us.core.pr.domain.entity;

import scala.collection.Seq;
import us.core.pr.domain.entity.constraints.Address;
import us.core.pr.domain.entity.constraints.PersonName;
import us.core.pr.domain.entity.listener.impl.EveryEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@EntityListeners(value = {
        EveryEntityListener.PreEveryEntityListener.class,
        EveryEntityListener.PostEveryEntityListener.class
})
@Table(indexes = {
        @Index(columnList = "studentId", unique = true),
        @Index(columnList = "name, surname", unique = false),
        @Index(columnList = "nationalId", unique = true)
})
@Entity
public class Student
        implements Serializable
{
    private Integer id;
    private String  studentId;
    private String  name;
    private String  surname;
    private String  nationalId;
    private String  address;

    /**
     * relationships
     */
    private Set<CourseTaken> courseTaken;

    public Student() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_stu_gen")
    @SequenceGenerator(name = "ent_stu_gen", initialValue = 1, allocationSize = 1)
    public Integer getId()
    {
        return this.id;
    }

    @Column
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

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    public Set<CourseTaken> getCourseTaken()
    {
        return courseTaken;
    }

    public void setId(Integer id)
    {
        this.id = id;
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

    public void addCourseTaken(CourseTaken courseTaken)
    {
        if (this.courseTaken == null)
        {
            this.courseTaken = new HashSet<>();
        }
        this.courseTaken.add(courseTaken);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return student.getStudentId().equals(studentId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(studentId);
    }
}