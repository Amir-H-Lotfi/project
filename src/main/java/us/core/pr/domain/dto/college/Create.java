package us.core.pr.domain.dto.college;

import us.core.pr.domain.dto.BaseDTO;
import us.core.pr.domain.dto.professor.Read;

import java.io.Serializable;
import java.util.*;

public class Create
        extends BaseDTO
        implements Serializable
{

    private String                                      name;
    private us.core.pr.domain.dto.professor.Read        headOfDepartment;
    private Set<us.core.pr.domain.dto.professor.Create> professors;
    private Set<us.core.pr.domain.dto.student.Create>   students;
    private Set<us.core.pr.domain.dto.course.Create>    courses;

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

    public Set<us.core.pr.domain.dto.professor.Create> getProfessors()
    {
        return professors;
    }

    public void setProfessors(Set<us.core.pr.domain.dto.professor.Create> professors)
    {
        this.professors = professors;
    }

    public Set<us.core.pr.domain.dto.student.Create> getStudents()
    {
        return students;
    }

    public void setStudents(Set<us.core.pr.domain.dto.student.Create> students)
    {
        this.students = students;
    }

    public Set<us.core.pr.domain.dto.course.Create> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<us.core.pr.domain.dto.course.Create> courses)
    {
        this.courses = courses;
    }

    public void addProfesors(us.core.pr.domain.dto.professor.Create professor)
    {
        professors.add(professor);
    }

    public void addStudent(us.core.pr.domain.dto.student.Create student)
    {
        students.add(student);
    }

    public void addCourse(us.core.pr.domain.dto.course.Create course)
    {
        courses.add(course);
    }
}
