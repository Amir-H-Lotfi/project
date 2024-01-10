package us.core.pr.domain.entity;

import us.core.pr.domain.entity.base.PersonEntity;
import us.core.pr.domain.entity.middle.CourseTaken;
import us.core.pr.validation.annotation.Address;
import us.core.pr.domain.entity.listener.impl.EveryEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SequenceGenerator(name = "default_generator", sequenceName = "ent_student_seq", initialValue = 1, allocationSize = 1)
@EntityListeners(value = {
        EveryEntityListener.PreEveryEntityListener.class,
        EveryEntityListener.PostEveryEntityListener.class
})
@Table(name = "student",
        indexes = {
                @Index(columnList = "studentId", unique = true),
                @Index(columnList = "name, surname", unique = false),
                @Index(columnList = "nationalId", unique = true)
        }
)
@Entity
public class Student
        extends PersonEntity
        implements Serializable
{
    private String studentId;
    private String address;

    /**
     * relationships
     */
    private Set<CourseTaken> courseTaken;

    public Student() {}

    @Column(length = 36)
    public String getStudentId()
    {
        return studentId;
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

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
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