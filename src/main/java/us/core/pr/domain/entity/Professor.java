package us.core.pr.domain.entity;

import jakarta.persistence.*;
import us.core.pr.domain.entity.constraints.PersonName;
import us.core.pr.domain.entity.logger.impl.ProfessorEntityListener;

import java.io.Serializable;
import java.util.List;

@Entity
public class Professor
        implements Serializable
{
    private String personnelId;
    private String name;
    private String surname;
    private String nationalId;

    /**
     * relationship
     */
    private College department;
    private List<Course> courses;


    public Professor() {}

    @Id
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

    @OneToOne
    @JoinTable(name = "head_of_department",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "college_name")
    )
    public College getDepartment()
    {
        return department;
    }

    @ManyToMany(mappedBy = "professors")
    public List<Course> getCourses()
    {
        return courses;
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

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }
}
