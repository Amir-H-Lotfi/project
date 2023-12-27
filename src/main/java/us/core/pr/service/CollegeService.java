package us.core.pr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.core.pr.domain.crud.interfaces.ICrudOperations;
import us.core.pr.domain.dto.CollegeDTO;
import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.domain.dto.ReportingDTO;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.ProfessorDTOMapper;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;
import us.core.pr.domain.entity.CourseTaken;
import us.core.pr.domain.entity.Professor;
import us.core.pr.domain.entity.Student;
import us.core.pr.exception.jpa.CollegeRecordNotFoundException;
import us.core.pr.exception.IllegalHeadOfDepartmentAssignmentException;
import us.core.pr.exception.jpa.RecordNotFoundException;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.service.abstracts.AbstractCollegeService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;


@Service
public class CollegeService
        extends AbstractCollegeService
{

    private final IDataTransferObjectMapperFactory factory;

    @Autowired
    public CollegeService(IDataTransferObjectMapperFactory factory, ICollegeRepository icRepository,
            ICrudOperations<CollegeDTO.Create, CollegeDTO.Read, CollegeDTO.Update, CollegeDTO.Delete, String> iCrudOperations)
    {
        super(icRepository, iCrudOperations);
        this.factory = factory;
    }


    @Override
    public void createEntity(CollegeDTO.Create entity)
    {
        super.iCrudOperations.create(entity);
    }

    @Override
    public CollegeDTO.Read readEntity(String key)
    {
        return super.iCrudOperations.read(key);
    }

    @Override
    public void updateEntity(CollegeDTO.Update entity)
    {
        super.iCrudOperations.update(entity);
    }

    @Override
    public void deleteEntity(CollegeDTO.Delete entity)
    {
        super.iCrudOperations.delete(entity);
    }

    @Override
    public void addHeadOfDepartment(ProfessorDTO.Read pRead, CollegeDTO.Update cUpdate)
    {
        try
        {
            IDataTransferObjectMapper<ProfessorDTO.Read, Professor> mapper = factory.create(ProfessorDTOMapper.ReadToProfessor.class);
            College college = super.icRepository.findById(cUpdate.getName()).orElseThrow(RecordNotFoundException::new);
            Professor professor = mapper.from(pRead);
            if (college.getProfessors().contains(professor))
            {
                college.setHeadOfDepartment(professor);
                super.icRepository.saveAndFlush(college);
            }
            else throw new IllegalHeadOfDepartmentAssignmentException();
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addProfessor(ProfessorDTO.Read pRead, CollegeDTO.Update cUpdate)
    {
        try
        {
            IDataTransferObjectMapper<ProfessorDTO.Read, Professor> mapper = factory.create(ProfessorDTOMapper.ReadToProfessor.class);
            College college = super.icRepository.findById(cUpdate.getName()).orElseThrow(RecordNotFoundException::new);
            Professor professor = mapper.from(pRead);
            college.getProfessors().add(professor);
            super.icRepository.saveAndFlush(college);
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ReportingDTO.RpCollegeAVG getStudentsAverage(CollegeDTO.Read read)
    {
        College college = icRepository.findById(read.getName()).orElseThrow(CollegeRecordNotFoundException::new);
        Set<Student> students = college.getStudents();
        BigDecimal allAvg, allAvgSum = BigDecimal.ZERO, allStudents = BigDecimal.valueOf(students.size());


        ReportingDTO.RpCollegeAVG.Builder builder = new ReportingDTO.RpCollegeAVG.Builder();
        for (Student student : students)
        {
            // calculate one student average
            BigDecimal sum = BigDecimal.ZERO, count = BigDecimal.ZERO, avg;

            for (CourseTaken courseTaken : student.getCourseTaken())
            {
                BigDecimal grade = BigDecimal.valueOf(courseTaken.getGrade());
                BigDecimal credit = BigDecimal.valueOf(courseTaken.getCourse().getCredit());
                sum = sum.add(grade.multiply(credit));
                count = count.add(credit);
            }

            avg = sum.divide(count, RoundingMode.UNNECESSARY);
            allAvgSum = allAvgSum.add(avg);

        }
        allAvg = allAvgSum.divide(allStudents, RoundingMode.UNNECESSARY);

        return builder
                .name(read.getName())
                .average(allAvg)
                .students(allStudents)
                .build();

//        College college = icRepository.findById(read.getName()).orElseThrow(RecordNotFoundException::new);
//
//        BigDecimal totalWMeanSum = BigDecimal.ZERO;
//        BigDecimal students = BigDecimal.valueOf(college.getStudents().size());
//
//        for (Student student : college.getStudents())
//        {
//            BigDecimal sum = BigDecimal.ZERO;
//            BigDecimal tWeight = BigDecimal.ZERO;
//            for (CourseTaken courseTaken : student.getCourseTaken())
//            {
//                BigDecimal grade = BigDecimal.valueOf(courseTaken.getGrade());
//                BigDecimal credit = BigDecimal.valueOf(courseTaken.getCourse().getCredit());
//                sum = sum.add(grade.multiply(credit));
//                tWeight = tWeight.add(credit);
//            }
//            BigDecimal wMean = sum.divide(tWeight, RoundingMode.UNNECESSARY);
//            totalWMeanSum = totalWMeanSum.add(wMean);
//        }
//        totalWMeanSum = totalWMeanSum.divide(students, RoundingMode.UNNECESSARY);
//
//        ReportingDTO.RpCollegeAVG ca = new ReportingDTO.RpCollegeAVG();
//        ca.setName(read.getName());
//        ca.setStudents(students);
//        ca.setAverage(totalWMeanSum);
//        return ca;

    }

}
