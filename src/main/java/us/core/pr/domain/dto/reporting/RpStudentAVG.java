package us.core.pr.domain.dto.reporting;

import java.io.Serializable;
import java.math.BigDecimal;

public class RpStudentAVG
        implements Serializable
{
    private String     studentId;
    private String     name;
    private String     surname;
    private BigDecimal average;

    public RpStudentAVG()
    {

    }

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
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
