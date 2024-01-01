package us.core.pr.domain.dto.reporting;

import java.io.Serializable;
import java.math.BigDecimal;

public class RpCourseTaught
        implements Serializable
{

    private String     name;
    private BigDecimal average;

    public RpCourseTaught()
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

    public BigDecimal getAverage()
    {
        return average;
    }

    public void setAverage(BigDecimal average)
    {
        this.average = average;
    }
}
