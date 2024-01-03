package us.core.pr.domain.entity;

import us.core.pr.domain.entity.constraints.PersonName;
import us.core.pr.domain.entity.listener.impl.EveryEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@EntityListeners(value = {
        EveryEntityListener.PreEveryEntityListener.class, EveryEntityListener.PostEveryEntityListener.class
})
@Table(indexes = {
        @Index(columnList = "personnelId", unique = true),
        @Index(columnList = "name, surname", unique = false),
        @Index(columnList = "nationalId", unique = true)
})
@Entity
public class Professor
        implements Serializable
{
    private Integer id;
    private String  personnelId;
    private String  name;
    private String  surname;
    private String  nationalId;

    /**
     * relationship
     */
    private College           department;
    private Set<CourseTaught> courseTaught;


    public Professor() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_pro_gen")
    @SequenceGenerator(name = "ent_pro_gen", initialValue = 1, allocationSize = 1)
    public Integer getId()
    {
        return this.id;
    }

    public String getPersonnelId()
    {
        return personnelId;
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

    @Column(unique = true)
    public String getNationalId()
    {
        return nationalId;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "head_of_department", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "college_name"))
    public College getDepartment()
    {
        return department;
    }

    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
    public Set<CourseTaught> getCourseTaught()
    {
        return courseTaught;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setPersonnelId(String personnelId)
    {
        this.personnelId = personnelId;
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

    public void setDepartment(College department)
    {
        this.department = department;
    }

    public void setCourseTaught(Set<CourseTaught> courseTaught)
    {
        this.courseTaught = courseTaught;
    }

    public void addCourseTaught(CourseTaught courseTaught)
    {
        if (this.courseTaught == null)
        {
            this.courseTaught = new HashSet<>();
        }
        this.courseTaught.add(courseTaught);
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return professor.getPersonnelId().equals(this.personnelId);
    }

    @Override
    public int hashCode()
    {
        return this.personnelId.hashCode();
    }
}
