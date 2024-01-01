package us.core.pr.domain.dto.reporting;

import java.io.Serializable;
import java.util.Set;

public class RpProfessorAVG
        implements Serializable
{
    private String              personnelId;
    private String              name;
    private Set<RpCourseTaught> avgReports;

    public RpProfessorAVG()
    {

    }

    public String getPersonnelId()
    {
        return personnelId;
    }

    public void setPersonnelId(String personnelId)
    {
        this.personnelId = personnelId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<RpCourseTaught> getAvgReports()
    {
        return avgReports;
    }

    public void setAvgReports(Set<RpCourseTaught> avgReports)
    {
        this.avgReports = avgReports;
    }
}
