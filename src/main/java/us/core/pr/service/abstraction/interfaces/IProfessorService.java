package us.core.pr.service.abstraction.interfaces;

import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.professor.Read;
import us.core.pr.domain.dto.professor.Update;
import us.core.pr.domain.dto.reporting.RpProfessorAVG;

import java.io.Serializable;

public interface IProfessorService
        extends Serializable
{
    void addCourse(Update pUpdate, Create cCreate);

    RpProfessorAVG getAverage(Read read);
}
