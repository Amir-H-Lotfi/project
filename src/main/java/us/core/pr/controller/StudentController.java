package us.core.pr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.abstracts.AbstractStudentController;
import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.reporting.RpStudentAVG;
import us.core.pr.domain.dto.student.Read;
import us.core.pr.domain.dto.student.Update;
import us.core.pr.service.interfaces.IStudentService;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController
        extends AbstractStudentController
{


    private Logger log = LoggerFactory.getLogger(getClass().getName());

    public StudentController(IStudentService iStudentService)
    {
        super(iStudentService);
    }

    // add course to student
    @PatchMapping(path = "/ac")
    public ResponseEntity<Object> addCourse(@ModelAttribute Update student, @RequestBody Create course)
    {
        log.info("Student Controller, addCourse Method, Called");
        super.iStudentService.addCourse(student, course);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/ga")
    public ResponseEntity<RpStudentAVG> getAverage(@ModelAttribute Read read)
    {
        RpStudentAVG rp = iStudentService.getAverage(read);
        return ResponseEntity.ok(rp);
    }

}
