package us.core.pr.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.core.pr.controller.abstraction.AbstractCollegeController;
import us.core.pr.domain.db.entities.university.College;
import us.core.pr.domain.dto.college.Update;
import us.core.pr.domain.dto.professor.Read;
import us.core.pr.domain.dto.reporting.RpCollegeAVG;
import us.core.pr.service.impl.CollegeService;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.university.college.CreateToCollege;
import us.core.pr.utils.mapper.impl.university.college.UpdateToCollege;

@RestController
@RequestMapping(path = "api/v1/university/colleges")
public class CollegeController
        extends AbstractCollegeController
{

    private IDataTransferObjectMapperFactory factory;

    public CollegeController(CollegeService iCollegeService, IDataTransferObjectMapperFactory factory)
    {
        super(iCollegeService);
        this.factory = factory;
    }

    // CRUD Operations

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> createSingleCollege(
            @RequestBody us.core.pr.domain.dto.college.Create create)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.college.Create, College> mapper = factory.create(CreateToCollege.class);
        College college = mapper.from(create);
        College createdCollege = service.create(college);
        return ResponseEntity.ok(createdCollege);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{key}")
    public ResponseEntity<Object> readSingleCollege(
            @PathVariable Integer key)
    {
        College college = service.read(key);
        return ResponseEntity.ok(college);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/{key}")
    public ResponseEntity<Object> updateSingleCollege(
            @PathVariable Integer key,
            @RequestBody us.core.pr.domain.dto.college.Update update)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.college.Update, College> mapper = factory.create(UpdateToCollege.class);
        College college = mapper.from(update);
        College updated = service.update(key, college);
        return ResponseEntity.ok(updated);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{key}")
    public ResponseEntity<Object> deleteSingleCollege(@PathVariable Integer key)
    {
        College deletedCollege = service.delete(key);
        return ResponseEntity.ok(deletedCollege);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/personnel/head-of-department")
    public ResponseEntity<Object> setHeadOfDepartment(Read professor, @RequestBody Update college)
    {

        service.addHeadOfDepartment(professor, college);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(method = RequestMethod.PATCH, path = "/personnel")
    public ResponseEntity<Object> addProfessor(Read professor, @RequestBody Update college)
    {
        service.addProfessor(professor, college);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reports")
    public ResponseEntity<RpCollegeAVG> getAverage(us.core.pr.domain.dto.college.Read read)
    {
        RpCollegeAVG rp = service.reportAverages(read);
        return ResponseEntity.ok(rp);
    }


}
