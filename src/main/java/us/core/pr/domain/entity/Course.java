package us.core.pr.domain.entity;

import us.core.pr.domain.entity.listener.impl.EveryEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@EntityListeners(value = {
        EveryEntityListener.PreEveryEntityListener.class,
        EveryEntityListener.PostEveryEntityListener.class
})
@Entity
public class Course
        implements Serializable
{

    private String  name;
    private Integer credit;


    /**
     * relationship
     */
    private Set<CourseTaught> courseTaught;
    private Set<CourseTaken>  courseTaken;

    public Course() {}

    @Id
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

    @OneToMany(mappedBy = "course")
    public Set<CourseTaught> getCourseTaught()
    {
        return courseTaught;
    }

    @OneToMany(mappedBy = "course")
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

}
