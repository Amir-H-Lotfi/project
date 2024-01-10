package us.core.pr.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.abstracts.AbstractCollegeController;
import us.core.pr.domain.dto.reporting.RpCollegeAVG;
import us.core.pr.service.abstraction.abstracts.AbstractCollegeService;

@RestController
@RequestMapping(path = "api/v1/colleges")
public class CollegeController
        extends AbstractCollegeController
{

    public CollegeController(AbstractCollegeService iCollegeService)
    {
        super(iCollegeService);
    }

    @PatchMapping(path = "/head-of-department")
    public ResponseEntity<Object> setHeadOfDepartment(
            us.core.pr.domain.dto.professor.Read professor,
            @RequestBody us.core.pr.domain.dto.college.Update college)
    {
        super.iCollegeService.addHeadOfDepartment(professor, college);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/professors")
    public ResponseEntity<Object> addProfessor(
            us.core.pr.domain.dto.professor.Read professor,
            @RequestBody us.core.pr.domain.dto.college.Update college)
    {
        super.iCollegeService.addProfessor(professor, college);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/professors/courses/reports")
    public ResponseEntity<RpCollegeAVG> getAverage(us.core.pr.domain.dto.college.Read read)
    {
        RpCollegeAVG rp = iCollegeService.getStudentsAverage(read);
        return ResponseEntity.ok(rp);
    }


}
