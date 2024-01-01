package us.core.pr.domain.dto.college;

import java.io.Serializable;
import java.math.BigDecimal;

public class Average
        implements Serializable
{
    private String     name;
    private BigDecimal students;
    private BigDecimal average;

    public Average()
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

    public BigDecimal getStudents()
    {
        return students;
    }

    public void setStudents(BigDecimal students)
    {
        this.students = students;
    }

    public BigDecimal getAverage()
    {
        return average;
    }

    public void setAverage(BigDecimal average)
    {
        this.average = average;
    }
}
