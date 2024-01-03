package us.core.pr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.domain.dto.college.Create;
import us.core.pr.domain.dto.college.Read;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.professor.ReadToProfessor;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.reporting.RpCollegeAVG;
import us.core.pr.domain.entity.College;
import us.core.pr.domain.entity.CourseTaken;
import us.core.pr.domain.entity.Professor;
import us.core.pr.domain.entity.Student;
import us.core.pr.exception.IllegalHeadOfDepartmentAssignmentException;
import us.core.pr.exception.RecordNotFoundException;
import us.core.pr.exception.entity.CollegeRecordNotFoundException;
import us.core.pr.exception.entity.ProfessorRecordNotFoundException;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.service.abstracts.AbstractCollegeService;
import us.core.pr.domain.dto.college.*;
import us.core.pr.utils.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;


@Service
@Transactional
public class CollegeService
        extends AbstractCollegeService
{

    private final IDataTransferObjectMapperFactory factory;

    @Autowired
    public CollegeService(IDataTransferObjectMapperFactory factory,
                          ICollegeRepository icRepository, ICrudOperations<Create, Read, Update, Delete, String> iCrudOperations)
    {
        super(icRepository, iCrudOperations);
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
    public void addHeadOfDepartment(us.core.pr.domain.dto.professor.Read pRead,
                                    Update cUpdate)
    {
        College college = icRepository.findByName(cUpdate.getName()).orElseThrow(CollegeRecordNotFoundException::new);
        IDataTransferObjectMapper<us.core.pr.domain.dto.professor.Read, Professor> mapper;
        Professor professor;
        try
        {
            mapper = factory.create(ReadToProfessor.class);
        }
        catch (IllegalAccessException | InstantiationException | IllegalHeadOfDepartmentAssignmentException e)
        {
            throw new RuntimeException(e);
        }
        professor = mapper.from(pRead);
        if (college.getProfessors().contains(professor))
        {
            college.setHeadOfDepartment(professor);
            professor.setDepartment(college);
            icRepository.saveAndFlush(college);
        }
        else throw new IllegalHeadOfDepartmentAssignmentException();
    }


    @Override
    public void addProfessor(us.core.pr.domain.dto.professor.Read pRead, Update cUpdate)
    {
        IDataTransferObjectMapper<us.core.pr.domain.dto.professor.Read, Professor> mapper;
        Professor professor;
        try
        {
            mapper = factory.create(ReadToProfessor.class);
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
        professor = mapper.from(pRead);
        College college = icRepository.findByName(cUpdate.getName()).orElseThrow(CollegeRecordNotFoundException::new);
        college.getProfessors().add(professor);
        icRepository.saveAndFlush(college);
    }

    @Override
    public RpCollegeAVG getStudentsAverage(Read read)
    {
        College college = icRepository.findByName(read.getName()).orElseThrow(CollegeRecordNotFoundException::new);
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

}
