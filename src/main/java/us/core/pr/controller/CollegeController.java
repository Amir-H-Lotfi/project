package us.core.pr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.abstracts.AbstractCollegeController;
import us.core.pr.domain.dto.college.Read;
import us.core.pr.domain.dto.college.Update;
import us.core.pr.domain.dto.reporting.RpCollegeAVG;
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
    public ResponseEntity<Object> setHeadOfDepartment(
            @ModelAttribute us.core.pr.domain.dto.professor.Read professor, @RequestBody Update college)
    {
        super.iCollegeService.addHeadOfDepartment(professor, college);
        return ResponseEntity.ok().build();
    }

    // add professor
    @PatchMapping(path = "/ap")
    public ResponseEntity<Object> addProfessor(
            @ModelAttribute us.core.pr.domain.dto.professor.Read professor, @RequestBody Update college)
    {
        super.iCollegeService.addProfessor(professor, college);
        return ResponseEntity.ok().build();
    }

    // get average
    @GetMapping("/ga")
    public ResponseEntity<RpCollegeAVG> getAverage(@ModelAttribute Read read)
    {
        RpCollegeAVG rp = iCollegeService.getStudentsAverage(read);
        return ResponseEntity.ok(rp);
    }


}
