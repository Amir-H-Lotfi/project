package us.core.pr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.abstracts.AbstractStudentController;
import us.core.pr.domain.dto.CourseDTO;
import us.core.pr.domain.dto.ReportingDTO;
import us.core.pr.domain.dto.StudentDTO;
import us.core.pr.service.interfaces.IStudentService;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController
        extends AbstractStudentController
{


    public StudentController(IStudentService iStudentService)
    {
        super(iStudentService);
    }

    // add course to student
    @PatchMapping(path = "/ac")
    public ResponseEntity<Object> addCourse(@RequestParam StudentDTO.Update student,
            @RequestBody CourseDTO.Create course)
    {
        super.iStudentService.addCourse(student, course);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/ga")
    public ResponseEntity<ReportingDTO.RpStudentAVG> getAverage(@RequestParam StudentDTO.Read read)
    {
        ReportingDTO.RpStudentAVG rp = iStudentService.getAverage(read);
        return ResponseEntity.ok(rp);
    }

}
