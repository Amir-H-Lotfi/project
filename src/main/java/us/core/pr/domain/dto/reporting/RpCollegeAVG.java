package us.core.pr.domain.dto.reporting;

import java.io.Serializable;
import java.math.BigDecimal;

public class RpCollegeAVG
        implements Serializable
{
    private String     name;
    private BigDecimal students;
    private BigDecimal average;

    public RpCollegeAVG()
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
