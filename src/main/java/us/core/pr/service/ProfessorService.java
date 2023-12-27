package us.core.pr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.domain.dto.CourseDTO;
import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.domain.dto.ReportingDTO;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.CourseDTOMapper;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Course;
import us.core.pr.domain.entity.CourseTaken;
import us.core.pr.domain.entity.CourseTaught;
import us.core.pr.domain.entity.Professor;
import us.core.pr.exception.jpa.RecordNotFoundException;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.service.abstracts.AbstractProfessorService;
import us.core.pr.service.interfaces.ICrudService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ProfessorService
        extends AbstractProfessorService
        implements ICrudService<ProfessorDTO.Create, ProfessorDTO.Read, ProfessorDTO.Update, ProfessorDTO.Delete, String>
{

    private final IDataTransferObjectMapperFactory factory;

    @Autowired
    public ProfessorService(IDataTransferObjectMapperFactory factory, IProfessorRepository ipRepository,
            ICrudOperations<ProfessorDTO.Create, ProfessorDTO.Read, ProfessorDTO.Update, ProfessorDTO.Delete, String> iCrudOperations)
    {
        super(ipRepository, iCrudOperations);
        this.factory = factory;
    }


    @Override
    public void createEntity(ProfessorDTO.Create entity)
    {
        super.iCrudOperations.create(entity);
    }

    @Override
    public ProfessorDTO.Read readEntity(String key)
    {
        return super.iCrudOperations.read(key);
    }

    @Override
    public void updateEntity(ProfessorDTO.Update entity)
    {
        super.iCrudOperations.update(entity);
    }

    @Override
    public void deleteEntity(ProfessorDTO.Delete entity)
    {
        super.iCrudOperations.delete(entity);
    }

    @Override
    public void addCourse(ProfessorDTO.Update pUpdate, CourseDTO.Create cCreate)
    {
        try
        {
            IDataTransferObjectMapper<CourseDTO.Create, Course> mapper = factory.create(CourseDTOMapper.CreateToCourse.class);
            Course course = mapper.from(cCreate);
            Professor professor = super.ipRepository.findById(pUpdate.getPersonnelId()).orElseThrow(RecordNotFoundException::new);
            // need to modify
            CourseTaught courseTaught = new CourseTaught();
            courseTaught.setCourse(course);
            courseTaught.setProfessor(professor);
            professor.getCourseTaught().add(courseTaught);
            super.ipRepository.saveAndFlush(professor);
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ReportingDTO.RpProfessorAVG getAverage(ProfessorDTO.Read read)
    {
        Professor professor = super.ipRepository.findById(read.getPersonnelId()).orElseThrow(RecordNotFoundException::new);
        ReportingDTO.RpProfessorAVG reportingProfessor = new ReportingDTO.RpProfessorAVG();
        reportingProfessor.setName(professor.getName());
        reportingProfessor.setPersonnelId(professor.getPersonnelId());
        BigDecimal sum, avg, credits;

        for (CourseTaught courseTaught : professor.getCourseTaught())
        {
            Course currentCourse = courseTaught.getCourse();
            credits = BigDecimal.ZERO;
            avg = BigDecimal.ZERO;
            sum = BigDecimal.ZERO;

            for (CourseTaken courseTaken : currentCourse.getCourseTaken())
            {
                BigDecimal grade = BigDecimal.valueOf(courseTaken.getGrade());
                BigDecimal credit = BigDecimal.valueOf(currentCourse.getCredit());
                sum = sum.add(grade.multiply(credit));
                credits = credits.add(credit);
            }
            avg = sum.divide(credits, RoundingMode.UNNECESSARY);

            ReportingDTO.RpCourseTaught reportingAverage = new ReportingDTO.RpCourseTaught();
            reportingAverage.setAverage(avg);
            reportingAverage.setCourseName(currentCourse.getName());
            reportingProfessor.addAverageReports(reportingAverage);
        }

        return reportingProfessor;
    }
}
