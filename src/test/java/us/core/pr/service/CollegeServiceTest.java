package us.core.pr.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import us.core.pr.domain.dto.college.Update;
import us.core.pr.domain.db.entities.university.College;
import us.core.pr.domain.db.entities.university.Course;
import us.core.pr.domain.db.entities.university.Professor;
import us.core.pr.domain.db.entities.university.Student;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.university.professor.ReadToProfessor;
import us.core.pr.domain.dto.professor.Read;
import us.core.pr.domain.dto.reporting.RpCollegeAVG;
import us.core.pr.domain.db.entities.university.mdt.CourseTaken;
import us.core.pr.error.exception.service.college.IllegalHeadOfDepartmentAssignmentException;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.service.impl.CollegeService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;


//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CollegeServiceTest
{
    @Mock
    IDataTransferObjectMapperFactory factory;
    @Mock
    ICollegeRepository repository;
    @InjectMocks
    CollegeService     service;

    @Before
    public void initialize()
    {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void addHeadOfDepartment() throws Exception
    {
        College college = getCollege(Boolean.TRUE);

        Read pRead = new Read();
        pRead.setPersonnelId("professor#personnel#id");
        pRead.setName("professor#name");

        Update cUpdate = new Update();
        cUpdate.setName("college#name");

        Mockito.when(repository.findByName(Mockito.anyString())).thenReturn(Optional.of(college));
        Mockito.when(factory.create(ReadToProfessor.class)).thenReturn(new ReadToProfessor());

        service.addHeadOfDepartment(pRead, cUpdate);
        Assertions.assertThat(college.getHeadOfDepartment()).isNotNull();
        Assertions.assertThat(college.getHeadOfDepartment().getDepartment()).isEqualTo(college);

    }

    @Test
    public void addHeadOfDepartment_Throw_IllegalHeadOfDepartmentAssignmentException() throws Exception
    {

        College college = getCollege(Boolean.FALSE);

        Read pRead = new Read();
        pRead.setPersonnelId("professor#personnel#id");
        pRead.setName("professor#name");

        Update cUpdate = new Update();
        cUpdate.setName("college#name");

        Mockito.when(repository.findByName(Mockito.anyString())).thenReturn(Optional.of(college));
        Mockito.when(factory.create(ReadToProfessor.class)).thenReturn(new ReadToProfessor());


        org.junit.jupiter.api.Assertions.assertThrows(IllegalHeadOfDepartmentAssignmentException.class, () -> service.addHeadOfDepartment(pRead, cUpdate));
    }

    @Test
    public void addProfessor() throws Exception
    {

        College college = getCollege(Boolean.FALSE);

        Mockito.when(factory.create(ReadToProfessor.class)).thenReturn(new ReadToProfessor());
        Mockito.when(repository.findByName(Mockito.anyString())).thenReturn(Optional.of(college));

        Read pRead = new Read();
        pRead.setPersonnelId("professor#personnel#id");
        pRead.setName("professor#name");

        Update cUpdate = new Update();
        cUpdate.setName("college#name");

        service.addProfessor(pRead, cUpdate);
        Assertions.assertThat(college.getProfessors()).isNotEmpty();

    }

    @Test
    public void getStudentAverage()
    {
        College college = getCollege(Boolean.FALSE);
        Mockito.when(repository.findByName(Mockito.anyString())).thenReturn(Optional.of(college));

        us.core.pr.domain.dto.college.Read read = new us.core.pr.domain.dto.college.Read();
        read.setName("college#name");
        RpCollegeAVG rp = service.reportAverages(read);
        Assertions.assertThat(rp.getName()).isEqualTo(read.getName());
        Assertions.assertThat(rp.getStudents()).isEqualTo(BigDecimal.valueOf(2));
        Assertions.assertThat(rp.getAverage()).isBetween(BigDecimal.valueOf(15), BigDecimal.valueOf(17));
    }


    public static College getCollege(Boolean hasProfessor)
    {
        College college = new College();
        college.setName("college#name");
        college.setCourses(new HashSet<>());
        college.setStudents(new HashSet<>());
        college.setProfessors(new HashSet<>());

        if (hasProfessor)
        {
            Professor professor = new Professor();
            professor.setPersonnelId("professor#personnel#id");
            college.addProfessor(professor);
        }


        Course course0 = new Course();
        course0.setName("course0#name");
        course0.setCredit(3);


        Course course1 = new Course();
        course1.setName("course1#name");
        course1.setCredit(2);

        college.addCourse(course0);
        college.addCourse(course1);


        Student student0 = new Student();
        student0.setStudentId("student0#id");
        student0.setName("student0#name");

        Student student1 = new Student();
        student1.setStudentId("student1#id");
        student1.setName("student1#name");

        CourseTaken taken0 = new CourseTaken();
        taken0.setCourse(course0);
        taken0.setStudent(student0);
        taken0.setGrade(16);

        CourseTaken taken1 = new CourseTaken();
        taken1.setCourse(course1);
        taken1.setStudent(student1);
        taken1.setGrade(14);

        student0.addCourseTaken(taken0);
        student1.addCourseTaken(taken1);

        college.addStudent(student0);
        college.addStudent(student1);

        return college;
    }

}