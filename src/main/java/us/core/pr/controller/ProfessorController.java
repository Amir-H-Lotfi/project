package us.core.pr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.abstracts.AbstractProfessorController;
import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.professor.Read;
import us.core.pr.domain.dto.professor.Update;
import us.core.pr.domain.dto.reporting.RpProfessorAVG;
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
    public ResponseEntity<Object> addCourse(@ModelAttribute Update professor, @RequestBody Create course)
    {
        super.iProfessorService.addCourse(professor, course);
        return ResponseEntity.ok().build();
    }

    // get average
    @GetMapping(path = "/ga")
    public ResponseEntity<RpProfessorAVG> getAverage(@ModelAttribute Read read)
    {
        RpProfessorAVG rp = iProfessorService.getAverage(read);
        return ResponseEntity.ok(rp);
    }
}
