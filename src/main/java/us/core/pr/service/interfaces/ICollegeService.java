package us.core.pr.service.interfaces;

import us.core.pr.domain.dto.CollegeDTO;
import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.domain.dto.ReportingDTO;

import java.io.Serializable;
import java.math.BigDecimal;

public interface ICollegeService
        extends Serializable
{
    void addHeadOfDepartment(ProfessorDTO.Update pUpdate, CollegeDTO.Update cUpdate);

    void addProfessor(ProfessorDTO.Read pRead, CollegeDTO.Update cUpdate);

    ReportingDTO.RpCollegeAVG getStudentsAverage(CollegeDTO.Read read);

}
