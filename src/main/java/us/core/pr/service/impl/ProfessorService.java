package us.core.pr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.professor.Read;
import us.core.pr.domain.dto.professor.Update;
import us.core.pr.domain.dto.reporting.RpCourseTaught;
import us.core.pr.domain.dto.reporting.RpProfessorAVG;
import us.core.pr.domain.db.entities.university.Course;
import us.core.pr.domain.db.entities.university.Professor;
import us.core.pr.domain.db.entities.university.mdt.CourseTaken;
import us.core.pr.domain.db.entities.university.mdt.CourseTaught;
import us.core.pr.error.exception.entity.ProfessorRecordNotFoundException;
import us.core.pr.error.exception.service.professor.ProfessorAddingCourseFailureException;
import us.core.pr.error.exception.service.professor.ProfessorFetchingReportFailureException;
import us.core.pr.error.exception.mapper.MapperNotFoundException;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.service.abstraction.AbstractGenericJpaService;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.university.course.CreateToCourse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
@Transactional
public class ProfessorService
        extends AbstractGenericJpaService<Professor, Integer, IProfessorRepository>
{

    private IDataTransferObjectMapperFactory factory;

    public ProfessorService(IProfessorRepository ipRepository, IDataTransferObjectMapperFactory factory)
    {
        super(ipRepository);
        this.factory = factory;
    }

    public void addCourse(Update pUpdate, Create cCreate)
    {
        try
        {
            Professor professor = repository.findByPersonnelId(pUpdate.getPersonnelId())
                    .orElseThrow(ProfessorRecordNotFoundException::new);
            IDataTransferObjectMapper<Create, Course> mapper =
                    factory.create(CreateToCourse.class);
            Course course = mapper.from(cCreate);
            // need to modify
            CourseTaught courseTaught = new CourseTaught();
            courseTaught.setCourse(course);
            courseTaught.setProfessor(professor);
            professor.getCourseTaught().add(courseTaught);
            repository.saveAndFlush(professor);
        }
        catch (MapperNotFoundException | ProfessorRecordNotFoundException e)
        {
            throw new ProfessorAddingCourseFailureException(e);
        }
    }

    public RpProfessorAVG getAverage(Read read)
    {
        try
        {

            Professor professor = repository.findByPersonnelId(read.getPersonnelId())
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
            throw new ProfessorFetchingReportFailureException(e);
        }
    }

}
