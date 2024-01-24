package us.core.pr.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.AbstractStudentController;
import us.core.pr.domain.db.entities.university.Student;
import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.reporting.RpStudentAVG;
import us.core.pr.domain.dto.student.Read;
import us.core.pr.domain.dto.student.Update;
import us.core.pr.service.impl.StudentService;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.university.student.CreateToStudent;
import us.core.pr.utils.mapper.impl.university.student.UpdateToStudent;


@RestController
@RequestMapping(path = "api/v1/university/students")
public class StudentController
        extends AbstractStudentController
{

    private IDataTransferObjectMapperFactory factory;

    public StudentController(StudentService service, IDataTransferObjectMapperFactory factory)
    {
        super(service);
        this.factory = factory;
    }


    // CRUD Operations

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> createSingleStudent(
            @RequestBody us.core.pr.domain.dto.student.Create create)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.student.Create, Student> mapper = factory.create(CreateToStudent.class);
        Student student = mapper.from(create);
        Student createdStudent = service.create(student);
        return ResponseEntity.ok(createdStudent);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{key}")
    public ResponseEntity<Object> readSingleStudent(
            @PathVariable Integer key)
    {
        Student student = service.read(key);
        return ResponseEntity.ok(student);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/{key}")
    public ResponseEntity<Object> updateSingleStudent(
            @PathVariable Integer key,
            @RequestBody us.core.pr.domain.dto.student.Update update)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.student.Update, Student> mapper = factory.create(UpdateToStudent.class);
        Student student = mapper.from(update);
        Student updatedStudent = service.update(key, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{key}")
    public ResponseEntity<Object> deleteSingleStudent(@PathVariable Integer key)
    {
        Student deletedStudent = service.delete(key);
        return ResponseEntity.ok(deletedStudent);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/courses")
    public ResponseEntity<Object> addCourse(Update student, @RequestBody Create course)
    {
        service.addCourse(student, course);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reports")
    public ResponseEntity<Object> getAverage(Read read)
    {
        RpStudentAVG rp = service.getAverage(read);
        return ResponseEntity.ok(rp);
    }

}
