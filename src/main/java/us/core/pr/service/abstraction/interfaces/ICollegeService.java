package us.core.pr.service.abstraction.interfaces;

import us.core.pr.domain.dto.college.Update;
import us.core.pr.domain.dto.professor.Read;
import us.core.pr.domain.dto.reporting.RpCollegeAVG;

import java.io.Serializable;

public interface ICollegeService
        extends Serializable
{
    void addHeadOfDepartment(Read pRead, Update cUpdate);

    void addProfessor(Read pRead, Update cUpdate);

    RpCollegeAVG getStudentsAverage(us.core.pr.domain.dto.college.Read read);

}
