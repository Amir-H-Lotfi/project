package us.core.pr.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.abstracts.AbstractProfessorController;
import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.professor.Read;
import us.core.pr.domain.dto.professor.Update;
import us.core.pr.domain.dto.reporting.RpProfessorAVG;
import us.core.pr.service.abstraction.abstracts.AbstractProfessorService;

@RestController
@RequestMapping(path = "api/v1/professors")
public class ProfessorController
        extends AbstractProfessorController
{
    public ProfessorController(AbstractProfessorService iProfessorService)
    {
        super(iProfessorService);
    }

    @PatchMapping(path = "/courses")
    public ResponseEntity<Object> addCourse(
            us.core.pr.domain.dto.professor.Update professor,
            @RequestBody us.core.pr.domain.dto.course.Create course)
    {
        super.iProfessorService.addCourse(professor, course);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/courses/reports")
    public ResponseEntity<RpProfessorAVG> getAverage(us.core.pr.domain.dto.professor.Read read)
    {
        RpProfessorAVG rp = iProfessorService.getAverage(read);
        return ResponseEntity.ok(rp);
    }
}
