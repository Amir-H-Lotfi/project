package us.core.pr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.reporting.RpStudentAVG;
import us.core.pr.domain.dto.student.Read;
import us.core.pr.domain.dto.student.Update;
import us.core.pr.domain.db.entities.university.Course;
import us.core.pr.domain.db.entities.university.Student;
import us.core.pr.domain.db.entities.university.mdt.CourseTaken;
import us.core.pr.error.exception.entity.StudentRecordNotFoundException;
import us.core.pr.error.exception.service.student.StudentFetchingReportFailureException;
import us.core.pr.error.exception.service.student.StudentTakingCourseFailureException;
import us.core.pr.error.exception.mapper.MapperNotFoundException;
import us.core.pr.repository.IStudentRepository;
import us.core.pr.service.abstraction.AbstractGenericJpaService;
import us.core.pr.utils.Calculator;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.university.course.CreateToCourse;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class StudentService
        extends AbstractGenericJpaService<Student, Integer, IStudentRepository>
{

    private IDataTransferObjectMapperFactory factory;

    public StudentService(IStudentRepository isRepository, IDataTransferObjectMapperFactory factory)
    {
        super(isRepository);
        this.factory = factory;
    }

    public void addCourse(Update sUpdate, Create cCreate)
    {
        try
        {
            Student student = repository.findByStudentId(sUpdate.getStudentId())
                    .orElseThrow(StudentRecordNotFoundException::new);

            IDataTransferObjectMapper<Create, Course> mapper =
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
            repository.saveAndFlush(student);

        }
        catch (MapperNotFoundException | StudentRecordNotFoundException e)
        {
            throw new StudentTakingCourseFailureException(e);
        }

    }

    public RpStudentAVG getAverage(Read read)
    {

        try
        {

            Student student = repository.findByStudentId(read.getStudentId()).orElseThrow(StudentRecordNotFoundException::new);

            BigDecimal avg = Calculator.average(student);

            RpStudentAVG rp = new RpStudentAVG();
            rp.setStudentId(read.getStudentId());
            rp.setName(student.getName());
            rp.setSurname(student.getSurname());
            rp.setAverage(avg);

            return rp;
        }
        catch (StudentRecordNotFoundException e)
        {
            throw new StudentFetchingReportFailureException(e);
        }
    }

}
