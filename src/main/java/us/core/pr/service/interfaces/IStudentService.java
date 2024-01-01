package us.core.pr.service.interfaces;

import java.io.Serializable;

import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.reporting.RpStudentAVG;
import us.core.pr.domain.dto.student.*;
public interface IStudentService
        extends Serializable
{
    void addCourse(Update update, Create create);

    RpStudentAVG getAverage(Read read);
}
