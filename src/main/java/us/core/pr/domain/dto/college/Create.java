package us.core.pr.domain.dto.college;

import us.core.pr.domain.dto.professor.Read;

import java.io.Serializable;
import java.util.*;

public class Create
        implements Serializable
{

    private String                                    name;
    private us.core.pr.domain.dto.professor.Read      headOfDepartment;
    private Set<us.core.pr.domain.dto.professor.Read> professors;
    private Set<us.core.pr.domain.dto.student.Read>   students;
    private Set<us.core.pr.domain.dto.course.Read>    courses;

    public Create()
    {
        professors = new HashSet<>();
        students = new HashSet<>();
        courses = new HashSet<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Read getHeadOfDepartment()
    {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Read headOfDepartment)
    {
        this.headOfDepartment = headOfDepartment;
    }

    public Set<Read> getProfessors()
    {
        return professors;
    }

    public void setProfessors(Set<Read> professors)
    {
        this.professors = professors;
    }

    public Set<us.core.pr.domain.dto.student.Read> getStudents()
    {
        return students;
    }

    public void setStudents(Set<us.core.pr.domain.dto.student.Read> students)
    {
        this.students = students;
    }

    public Set<us.core.pr.domain.dto.course.Read> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<us.core.pr.domain.dto.course.Read> courses)
    {
        this.courses = courses;
    }
}
