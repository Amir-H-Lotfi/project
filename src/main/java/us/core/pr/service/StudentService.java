package us.core.pr.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.course.CreateToCourse;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.reporting.RpStudentAVG;
import us.core.pr.domain.entity.Course;
import us.core.pr.domain.entity.CourseTaken;
import us.core.pr.domain.entity.Student;
import us.core.pr.exception.RecordNotFoundException;
import us.core.pr.exception.entity.StudentRecordNotFoundException;
import us.core.pr.repository.IStudentRepository;
import us.core.pr.service.abstracts.AbstractStudentService;
import us.core.pr.domain.crud.interfaces.ICrudOperations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import us.core.pr.domain.dto.student.*;
import us.core.pr.utils.Calculator;

@Service
@Transactional
public class StudentService
        extends AbstractStudentService
{
    private final IDataTransferObjectMapperFactory factory;

    public StudentService(IDataTransferObjectMapperFactory factory, IStudentRepository isRepository, ICrudOperations<Create, Read, Update, Delete, String> iCrudOperations)
    {
        super(isRepository, iCrudOperations);
        this.factory = factory;
    }

    public IDataTransferObjectMapperFactory getFactory()
    {
        return factory;
    }

    @Override
    public void createEntity(Create entity)
    {
        super.iCrudOperations.create(entity);
    }

    @Override
    public Read readEntity(String key)
    {
        return iCrudOperations.read(key);
    }

    @Override
    public void updateEntity(Update entity)
    {
        super.iCrudOperations.update(entity);
    }

    @Override
    public void deleteEntity(Delete entity)
    {
        super.iCrudOperations.delete(entity);
    }

    // pure logic need to modify.
    @Override
    public void addCourse(Update sUpdate, us.core.pr.domain.dto.course.Create cCreate)
    {
        try
        {
            Student student = super.isRepository.findByStudentId(sUpdate.getStudentId())
                                                .orElseThrow(RecordNotFoundException::new);

            IDataTransferObjectMapper<us.core.pr.domain.dto.course.Create, Course> mapper =
                    factory.create(CreateToCourse.class);

            Course course = mapper.from(cCreate);

            int randomGrade = new Random().nextInt(20) + 1;

            CourseTaken courseTaken = new CourseTaken();

            CourseTaken.CompositeKey compositeKey = new CourseTaken.CompositeKey();
            compositeKey.setCourseId(course.getId());
            compositeKey.setStudentId(student.getId());

            courseTaken.setCompositeKey(compositeKey);

            courseTaken.setCourse(course);
            courseTaken.setStudent(student);
            courseTaken.setGrade(randomGrade);

            student.getCourseTaken().add(courseTaken);
            isRepository.saveAndFlush(student);

        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public RpStudentAVG getAverage(Read read)
    {

        Student student = isRepository.findByStudentId(read.getStudentId()).orElseThrow(StudentRecordNotFoundException::new);

        BigDecimal avg = Calculator.average(student);

        RpStudentAVG rp = new RpStudentAVG();
        rp.setStudentId(read.getStudentId());
        rp.setName(student.getName());
        rp.setSurname(student.getSurname());
        rp.setAverage(avg);

        return rp;
    }
}
