package us.core.pr.domain.entity;

import us.core.pr.domain.entity.base.PersonEntity;
import us.core.pr.domain.entity.listener.impl.EveryEntityListener;
import us.core.pr.domain.entity.middle.CourseTaught;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "default_generator", sequenceName = "ent_professor_seq", initialValue = 1, allocationSize = 1)
@EntityListeners(value = {
        EveryEntityListener.PreEveryEntityListener.class,
        EveryEntityListener.PostEveryEntityListener.class
})
@Table(name = "professor",
        indexes = {
                @Index(columnList = "personnelId", unique = true),
                @Index(columnList = "name, surname", unique = false),
                @Index(columnList = "nationalId", unique = true)
        }
)
@Entity
public class Professor
        extends PersonEntity
        implements Serializable
{
    private String personnelId;

    private College           department;
    private Set<CourseTaught> courseTaught;


    public Professor() {}

    @Column
    public String getPersonnelId()
    {
        return personnelId;
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


    public void setPersonnelId(String personnelId)
    {
        this.personnelId = personnelId;
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
