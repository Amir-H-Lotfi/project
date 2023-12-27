package us.core.pr.service.interfaces;

import us.core.pr.domain.dto.CourseDTO;
import us.core.pr.domain.dto.ReportingDTO;
import us.core.pr.domain.dto.StudentDTO;
import us.core.pr.service.interfaces.ICrudService;

import java.io.Serializable;

public interface IStudentService
        extends Serializable
{
    void addCourse(StudentDTO.Update update, CourseDTO.Create create);

    ReportingDTO.RpStudentAVG getAverage(StudentDTO.Read read);
}
