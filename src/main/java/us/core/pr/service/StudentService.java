package us.core.pr.service;

import org.springframework.stereotype.Service;
import us.core.pr.domain.dto.CourseDTO;
import us.core.pr.domain.dto.ReportingDTO;
import us.core.pr.domain.dto.StudentDTO;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.CourseDTOMapper;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Course;
import us.core.pr.domain.entity.CourseTaken;
import us.core.pr.domain.entity.Student;
import us.core.pr.exception.jpa.RecordNotFoundException;
import us.core.pr.repository.IStudentRepository;
import us.core.pr.service.abstracts.AbstractStudentService;
import us.core.pr.domain.crud.interfaces.ICrudOperations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@Service
public class StudentService
        extends AbstractStudentService
{
    private final IDataTransferObjectMapperFactory factory;

    public StudentService(IDataTransferObjectMapperFactory factory, IStudentRepository isRepository,
            ICrudOperations<StudentDTO.Create, StudentDTO.Read, StudentDTO.Update, StudentDTO.Delete, String> iCrudOperations)
    {
        super(isRepository, iCrudOperations);
        this.factory = factory;
    }

    @Override
    public void createEntity(StudentDTO.Create entity)
    {
        super.iCrudOperations.create(entity);
    }

    @Override
    public StudentDTO.Read readEntity(String key)
    {
        return iCrudOperations.read(key);
    }

    @Override
    public void updateEntity(StudentDTO.Update entity)
    {
        super.iCrudOperations.update(entity);
    }

    @Override
    public void deleteEntity(StudentDTO.Delete entity)
    {
        super.iCrudOperations.delete(entity);
    }

    // pure logic need to modify.
    @Override
    public void addCourse(StudentDTO.Update sUpdate, CourseDTO.Create cCreate)
    {
        try
        {
            Student student = super.isRepository.findById(sUpdate.getStudentId()).orElseThrow(RecordNotFoundException::new);
            IDataTransferObjectMapper<CourseDTO.Create, Course> mapper = factory.create(CourseDTOMapper.CreateToCourse.class);
            Course course = mapper.from(cCreate);

            int randomGrade = new Random().nextInt(20) + 1;

            CourseTaken courseTaken = new CourseTaken();
            CourseTaken.CompositeKey compositeKey = new CourseTaken.CompositeKey();
            compositeKey.setCourseId(course.getName());
            compositeKey.setStudentId(student.getStudentId());

            courseTaken.setCompositeKey(compositeKey);
            courseTaken.setCourse(course);
            courseTaken.setStudent(student);
            courseTaken.setGrade(randomGrade);

            student.getCourseTaken().add(courseTaken);
            super.isRepository.saveAndFlush(student);

        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ReportingDTO.RpStudentAVG getAverage(StudentDTO.Read read)
    {
        Student student = super.isRepository.findById(read.getStudentId()).orElseThrow(RecordNotFoundException::new);

        BigDecimal sum = BigDecimal.ZERO, avg, count = BigDecimal.valueOf(student.getCourseTaken().size());
        for (CourseTaken courseTaken : student.getCourseTaken())
        {
            BigDecimal grade = BigDecimal.valueOf(courseTaken.getGrade());
            BigDecimal credit = BigDecimal.valueOf(courseTaken.getCourse().getCredit());
            sum = sum.add(grade.multiply(credit));
        }
        avg = sum.divide(count, RoundingMode.UNNECESSARY);

        return new ReportingDTO.RpStudentAVG.Builder()
                .studentId(read.getStudentId())
                .name(read.getName())
                .average(avg)
                .build();
    }
}
