package us.core.pr.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import us.core.pr.controller.abstraction.abstracts.AbstractStudentController;
import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.reporting.RpStudentAVG;
import us.core.pr.domain.dto.student.Read;
import us.core.pr.domain.dto.student.Update;
import us.core.pr.service.abstraction.abstracts.AbstractStudentService;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController
        extends AbstractStudentController
{

    public StudentController(AbstractStudentService iStudentService)
    {
        super(iStudentService);
    }

    @PatchMapping(path = "/courses")
    public ResponseEntity<Object> addCourse(
            us.core.pr.domain.dto.student.Update student,
            @RequestBody us.core.pr.domain.dto.course.Create course)
    {
        iStudentService.addCourse(student, course);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/courses/reports")
    public ResponseEntity<RpStudentAVG> getAverage(us.core.pr.domain.dto.student.Read read)
    {
        RpStudentAVG rp = iStudentService.getAverage(read);
        return ResponseEntity.ok(rp);
    }

}
