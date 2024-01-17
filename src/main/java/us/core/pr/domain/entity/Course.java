package us.core.pr.domain.entity;

import us.core.pr.domain.entity.base.BaseEntity;
import us.core.pr.domain.entity.listeners.impl.EveryEntityListener;
import us.core.pr.domain.entity.middle.CourseTaken;
import us.core.pr.domain.entity.middle.CourseTaught;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "default_generator", sequenceName = "ent_course_seq", initialValue = 1, allocationSize = 1)
@EntityListeners(value = {
        EveryEntityListener.PreEveryEntityListener.class,
        EveryEntityListener.PostEveryEntityListener.class
})
@Table(name = "course",
        indexes = {
                @Index(columnList = "name", unique = true)
        })
@Entity
public class Course
        extends BaseEntity
        implements Serializable
{

    private String  name;
    private Integer credit;


    private Set<CourseTaught> courseTaught;
    private Set<CourseTaken>  courseTaken;

    public Course() {}

    public Course(String name, Integer credit)
    {
        this.name = name;
        this.credit = credit;
    }

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

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    public Set<CourseTaught> getCourseTaught()
    {
        return courseTaught;
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    public Set<CourseTaken> getCourseTaken()
    {
        return courseTaken;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCredit(Integer credit)
    {
        this.credit = credit;
    }

    public void setCourseTaught(Set<CourseTaught> courseTaught)
    {
        this.courseTaught = courseTaught;
    }

    public void setCourseTaken(Set<CourseTaken> students)
    {
        this.courseTaken = students;
    }

    public void addCourseTaken(CourseTaken courseTaken)
    {
        if (this.courseTaken == null)
        {
            this.courseTaken = new HashSet<>();
        }
        this.courseTaken.add(courseTaken);
    }

    public void addCourseTaught(CourseTaught courseTaught)
    {
        if (this.courseTaught == null)
        {
            this.courseTaught = new HashSet<>();
        }
        this.courseTaught.add(courseTaught);
    }

}
