package us.core.pr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.core.pr.domain.dto.college.Read;
import us.core.pr.domain.dto.college.Update;
import us.core.pr.domain.dto.reporting.RpCollegeAVG;
import us.core.pr.domain.db.entities.university.College;
import us.core.pr.domain.db.entities.university.Professor;
import us.core.pr.domain.db.entities.university.Student;
import us.core.pr.error.exception.entity.CollegeRecordNotFoundException;
import us.core.pr.error.exception.service.college.CollegeFetchingReportFailureException;
import us.core.pr.error.exception.service.college.HeadOfDepartmentAssignmentFailureException;
import us.core.pr.error.exception.service.college.IllegalHeadOfDepartmentAssignmentException;
import us.core.pr.error.exception.service.college.ProfessorToCollegeAssignmentFailureException;
import us.core.pr.error.exception.mapper.MapperNotFoundException;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.service.abstraction.AbstractGenericJpaService;
import us.core.pr.utils.Calculator;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.university.professor.ReadToProfessor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


@Service
@Transactional
public class CollegeService
        extends AbstractGenericJpaService<College, Integer, ICollegeRepository>
{

    private IDataTransferObjectMapperFactory factory;

    public CollegeService(ICollegeRepository icRepository, IDataTransferObjectMapperFactory factory)
    {
        super(icRepository);
        this.factory = factory;
    }


    public void addHeadOfDepartment(us.core.pr.domain.dto.professor.Read pRead, Update cUpdate)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.professor.Read, Professor> mapper;
        College college;
        Professor professor;
        try
        {
            college = repository.findByName(cUpdate.getName()).orElseThrow(CollegeRecordNotFoundException::new);
            mapper = factory.create(ReadToProfessor.class);
        }
        catch (MapperNotFoundException | CollegeRecordNotFoundException e)
        {
            throw new HeadOfDepartmentAssignmentFailureException(e);
        }
        professor = mapper.from(pRead);
        if (college.getProfessors().contains(professor))
        {
            college.setHeadOfDepartment(professor);
            professor.setDepartment(college);
            repository.saveAndFlush(college);
        }
        else throw new IllegalHeadOfDepartmentAssignmentException();
    }


    public void addProfessor(us.core.pr.domain.dto.professor.Read pRead, Update cUpdate)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.professor.Read, Professor> mapper;
        Professor professor;
        try
        {
            mapper = factory.create(ReadToProfessor.class);
            professor = mapper.from(pRead);
            College college = repository.findByName(cUpdate.getName()).orElseThrow(CollegeRecordNotFoundException::new);
            college.getProfessors().add(professor);
            repository.saveAndFlush(college);
        }
        catch (CollegeRecordNotFoundException e)
        {
            throw new ProfessorToCollegeAssignmentFailureException(e);
        }
    }

    public RpCollegeAVG reportAverages(Read read)
    {
        try
        {

            College college = repository.findByName(read.getName()).orElseThrow(CollegeRecordNotFoundException::new);
            Set<Student> students = college.getStudents();

            BigDecimal totalAverages = BigDecimal.ZERO, totalStudents = BigDecimal.valueOf(students.size());

            for (Student student : students)
            {
                BigDecimal avg = Calculator.average(student);
                totalAverages = totalAverages.add(avg);
            }

            totalAverages = totalAverages.divide(totalStudents, RoundingMode.CEILING);

            RpCollegeAVG rp = new RpCollegeAVG();
            rp.setName(college.getName());
            rp.setAverage(totalAverages);
            rp.setStudents(totalStudents);
            return rp;
        }
        catch (CollegeRecordNotFoundException e)
        {
            throw new CollegeFetchingReportFailureException(e);
        }
    }

}
