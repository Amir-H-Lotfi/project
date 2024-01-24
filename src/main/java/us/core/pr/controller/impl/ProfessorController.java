package us.core.pr.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.AbstractProfessorController;
import us.core.pr.domain.db.entities.university.Professor;
import us.core.pr.domain.dto.reporting.RpProfessorAVG;
import us.core.pr.service.impl.ProfessorService;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.university.professor.CreateToProfessor;
import us.core.pr.utils.mapper.impl.university.professor.UpdateToProfessor;

@RestController
@RequestMapping(path = "api/v1/university/professors")
public class ProfessorController
        extends AbstractProfessorController
{
    private IDataTransferObjectMapperFactory factory;

    public ProfessorController(ProfessorService service, IDataTransferObjectMapperFactory factory)
    {
        super(service);
        this.factory = factory;
    }

    // CRUD Operations

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> createSingleProfessor(
            @RequestBody us.core.pr.domain.dto.professor.Create create)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.professor.Create, Professor> mapper = factory.create(CreateToProfessor.class);
        Professor professor = mapper.from(create);
        Professor createdProfessor = service.create(professor);
        return ResponseEntity.ok(createdProfessor);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{key}")
    public ResponseEntity<Object> readSingleProfessor(
            @PathVariable Integer key)
    {
        Professor professor = service.read(key);
        return ResponseEntity.ok(professor);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/{key}")
    public ResponseEntity<Object> updateSingleProfessor(
            @PathVariable Integer key,
            @RequestBody us.core.pr.domain.dto.professor.Update update)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.professor.Update, Professor> mapper = factory.create(UpdateToProfessor.class);
        Professor professor = mapper.from(update);
        Professor updatedProfessor = service.update(key, professor);
        return ResponseEntity.ok(updatedProfessor);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{key}")
    public ResponseEntity<Object> deleteSingleProfessor(@PathVariable Integer key)
    {
        Professor deletedProfessor = service.delete(key);
        return ResponseEntity.ok(deletedProfessor);
    }


    @RequestMapping(method = RequestMethod.PATCH, path = "/courses")
    public ResponseEntity<Object> addCourse(us.core.pr.domain.dto.professor.Update professor,
            @RequestBody us.core.pr.domain.dto.course.Create course)
    {
        service.addCourse(professor, course);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reports")
    public ResponseEntity<RpProfessorAVG> getAverage(us.core.pr.domain.dto.professor.Read read)
    {
        RpProfessorAVG rp = service.getAverage(read);
        return ResponseEntity.ok(rp);
    }
}
