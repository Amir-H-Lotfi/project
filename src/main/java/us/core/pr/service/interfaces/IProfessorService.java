package us.core.pr.service.interfaces;

import us.core.pr.domain.dto.CourseDTO;
import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.domain.dto.ReportingDTO;

import java.io.Serializable;

public interface IProfessorService
        extends Serializable
{
    void addCourse(ProfessorDTO.Update pUpdate, CourseDTO.Create cCreate);

    ReportingDTO.RpProfessorAVG getAverage(ProfessorDTO.Read read);
}
