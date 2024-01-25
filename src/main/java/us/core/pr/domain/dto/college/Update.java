package us.core.pr.domain.dto.college;


import java.io.Serializable;
import java.util.*;

public class Update
        implements Serializable
{
    private String                                      name;
    private us.core.pr.domain.dto.professor.Update      headOfDepartment;
    private Set<us.core.pr.domain.dto.student.Update>   students;
    private Set<us.core.pr.domain.dto.course.Update>    courses;
    private Set<us.core.pr.domain.dto.professor.Update> professors;


    public Update()
    {

    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public us.core.pr.domain.dto.professor.Update getHeadOfDepartment()
    {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(us.core.pr.domain.dto.professor.Update headOfDepartment)
    {
        this.headOfDepartment = headOfDepartment;
    }

    public Set<us.core.pr.domain.dto.student.Update> getStudents()
    {
        return students;
    }

    public void setStudents(Set<us.core.pr.domain.dto.student.Update> students)
    {
        this.students = students;
    }

    public Set<us.core.pr.domain.dto.course.Update> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<us.core.pr.domain.dto.course.Update> courses)
    {
        this.courses = courses;
    }

    public Set<us.core.pr.domain.dto.professor.Update> getProfessors()
    {
        return professors;
    }

    public void setProfessors(Set<us.core.pr.domain.dto.professor.Update> professors)
    {
        this.professors = professors;
    }
}
