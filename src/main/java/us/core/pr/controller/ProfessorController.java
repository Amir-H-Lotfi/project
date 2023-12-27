package us.core.pr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.core.pr.controller.abstraction.abstracts.AbstractProfessorController;
import us.core.pr.domain.dto.CourseDTO;
import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.domain.dto.ReportingDTO;
import us.core.pr.service.interfaces.IProfessorService;

@RestController
@RequestMapping(path = "api/v1/professor")
public class ProfessorController
        extends AbstractProfessorController
{
    public ProfessorController(IProfessorService iProfessorService)
    {
        super(iProfessorService);
    }

    // add course to professor
    @PatchMapping(path = "/ac")
    public ResponseEntity<Object> addCourse(ProfessorDTO.Update professor, CourseDTO.Create course)
    {
        super.iProfessorService.addCourse(professor, course);
        return ResponseEntity.ok().build();
    }

    // get average
    @GetMapping(path = "/ga")
    public ResponseEntity<ReportingDTO.RpProfessorAVG> getAverage(ProfessorDTO.Read read)
    {

        ReportingDTO.RpProfessorAVG rp = iProfessorService.getAverage(read);
        return ResponseEntity.ok(rp);
    }
}
