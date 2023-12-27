package us.core.pr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.abstracts.AbstractCollegeController;
import us.core.pr.domain.dto.CollegeDTO;
import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.domain.dto.ReportingDTO;
import us.core.pr.domain.dto.StudentDTO;
import us.core.pr.domain.entity.Student;
import us.core.pr.service.interfaces.ICollegeService;

@RestController
@RequestMapping(path = "api/v1/college")
public class CollegeController
        extends AbstractCollegeController
{

    public CollegeController(ICollegeService iCollegeService)
    {
        super(iCollegeService);
    }

    // add head of department
    @PatchMapping(path = "/hod")
    public ResponseEntity<Object> setHeadOfDepartment(@RequestParam ProfessorDTO.Update professor,
            @RequestBody CollegeDTO.Update college)
    {
        super.iCollegeService.addHeadOfDepartment(professor, college);
        return ResponseEntity.ok().build();
    }

    // add professor
    @PatchMapping(path = "/ap")
    public ResponseEntity<Object> addProfessor(@RequestParam ProfessorDTO.Read professor,
            @RequestBody CollegeDTO.Update college)
    {
        super.iCollegeService.addProfessor(professor, college);
        return ResponseEntity.ok().build();
    }

    // get average
    @GetMapping("/ga")
    public ResponseEntity<ReportingDTO.RpCollegeAVG> getAverage(@RequestParam CollegeDTO.Read read)
    {
        ReportingDTO.RpCollegeAVG rp = iCollegeService.getStudentsAverage(read);
        return ResponseEntity.ok(rp);
    }


}
