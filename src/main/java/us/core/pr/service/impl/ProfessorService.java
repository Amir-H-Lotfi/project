package us.core.pr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.core.pr.domain.crud.abstractions.interfaces.ICrudOperations;
import us.core.pr.exception.service.professor.ProfessorAddingCourseFailureException;
import us.core.pr.exception.service.professor.ProfessorFetchingReportFailureException;
import us.core.pr.exception.utils.mapper.MapperNotFoundException;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.course.CreateToCourse;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.dto.reporting.RpCourseTaught;
import us.core.pr.domain.dto.reporting.RpProfessorAVG;
import us.core.pr.domain.entity.Course;
import us.core.pr.domain.entity.middle.CourseTaken;
import us.core.pr.domain.entity.middle.CourseTaught;
import us.core.pr.domain.entity.Professor;
import us.core.pr.exception.entity.ProfessorRecordNotFoundException;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.service.abstraction.abstracts.AbstractProfessorService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import us.core.pr.domain.dto.professor.*;

@Service
@Transactional
public class ProfessorService
        extends AbstractProfessorService
{

    private final IDataTransferObjectMapperFactory factory;

    @Autowired
    public ProfessorService(IDataTransferObjectMapperFactory factory, IProfessorRepository ipRepository,
            ICrudOperations<Create, Read, Update, Delete, String> iCrudOperations)
    {
        super(ipRepository, iCrudOperations);
        this.factory = factory;
    }


    @Override
    public void createEntity(Create entity)
    {
        super.iCrudOperations.create(entity);
    }

    @Override
    public Read readEntity(String key)
    {
        return super.iCrudOperations.read(key);
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

    @Override
    public void addCourse(Update pUpdate, us.core.pr.domain.dto.course.Create cCreate)
    {
        try
        {
            Professor professor = ipRepository.findByPersonnelId(pUpdate.getPersonnelId())
                    .orElseThrow(ProfessorRecordNotFoundException::new);
            IDataTransferObjectMapper<us.core.pr.domain.dto.course.Create, Course> mapper =
                    factory.create(CreateToCourse.class);
            Course course = mapper.from(cCreate);
            // need to modify
            CourseTaught courseTaught = new CourseTaught();
            courseTaught.setCourse(course);
            courseTaught.setProfessor(professor);
            professor.getCourseTaught().add(courseTaught);
            super.ipRepository.saveAndFlush(professor);
        }
        catch (MapperNotFoundException | ProfessorRecordNotFoundException e)
        {
            throw new ProfessorAddingCourseFailureException(e);
        }
    }

    @Override
    public RpProfessorAVG getAverage(Read read)
    {
        try
        {

            Professor professor = ipRepository.findByPersonnelId(read.getPersonnelId())
                    .orElseThrow(ProfessorRecordNotFoundException::new);

            RpProfessorAVG rp = new RpProfessorAVG();
            Set<RpCourseTaught> set = new HashSet<>();

            for (CourseTaught courseTaught : professor.getCourseTaught())
            {
                Course currentCourse = courseTaught.getCourse();

                BigDecimal currentCourseCredit = BigDecimal.valueOf(currentCourse.getCredit());
                BigDecimal sum = BigDecimal.ZERO;
                BigDecimal credits = BigDecimal.ZERO;
                BigDecimal avg;

                // calculating average by course title
                for (CourseTaken courseTaken : currentCourse.getCourseTaken())
                {
                    BigDecimal currentCourseGrade = BigDecimal.valueOf(courseTaken.getGrade());
                    sum = sum.add(currentCourseGrade.multiply(currentCourseCredit));
                    credits = credits.add(currentCourseCredit);
                }

                avg = sum.divide(credits, RoundingMode.DOWN);

                RpCourseTaught rpCourseTaught = new RpCourseTaught();
                rpCourseTaught.setName(currentCourse.getName());
                rpCourseTaught.setAverage(avg);

                set.add(rpCourseTaught);
            }

            rp.setPersonnelId(professor.getPersonnelId());
            rp.setName(professor.getName());
            rp.setAvgReports(set);
            return rp;
        }
        catch (ProfessorRecordNotFoundException e)
        {
            throw new ProfessorFetchingReportFailureException(e) ;
        }
    }

}
