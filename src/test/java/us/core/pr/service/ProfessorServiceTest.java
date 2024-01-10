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
import us.core.pr.domain.dto.course.Create;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.course.CreateToCourse;
import us.core.pr.domain.dto.professor.Read;
import us.core.pr.domain.dto.professor.Update;
import us.core.pr.domain.dto.reporting.RpCourseTaught;
import us.core.pr.domain.dto.reporting.RpProfessorAVG;
import us.core.pr.domain.entity.*;
import us.core.pr.domain.entity.middle.CourseTaken;
import us.core.pr.domain.entity.middle.CourseTaught;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.service.impl.ProfessorService;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ProfessorServiceTest
{
    @Mock
    IDataTransferObjectMapperFactory factory;
    @Mock
    IProfessorRepository repository;
    @InjectMocks
    ProfessorService     service;

    @Before
    public void initialize()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addCourse() throws Exception
    {
        Professor professor = getProfessor();

        Mockito.when(repository.findByPersonnelId(Mockito.anyString())).thenReturn(Optional.of(professor));
        Mockito.when(factory.create(CreateToCourse.class)).thenReturn(new CreateToCourse());

        Update pUpdate = new Update();
        pUpdate.setPersonnelId(professor.getPersonnelId());

        Create cCreate = new Create();
        cCreate.setName("created#course#name");
        cCreate.setCredit(2);

        service.addCourse(pUpdate, cCreate);
        CourseTaught[] courseTaughtSet = professor.getCourseTaught().toArray(new CourseTaught[0]);

        Assertions.assertThat(courseTaughtSet.length).isEqualTo(2);
        Assertions.assertThat(courseTaughtSet[1].getProfessor()).isEqualTo(professor);
    }

    @Test
    public void getAverage()
    {

        Professor professor = getProfessor();
        Mockito.when(repository.findByPersonnelId(Mockito.anyString())).thenReturn(Optional.of(professor));

        Read read = new Read();
        read.setPersonnelId(professor.getPersonnelId());
        read.setName(professor.getName());

        RpProfessorAVG rp = service.getAverage(read);
        Assertions.assertThat(rp.getName()).isEqualTo(professor.getName());
        Assertions.assertThat(rp.getPersonnelId()).isEqualTo(professor.getPersonnelId());
        Assertions.assertThat(rp.getAvgReports().size()).isOne();
        RpCourseTaught[] rpC = rp.getAvgReports().toArray(new RpCourseTaught[0]);
        Assertions.assertThat(rpC[0].getName()).isEqualTo("course#name");
        Assertions.assertThat(rpC[0].getAverage()).isBetween(BigDecimal.valueOf(12), BigDecimal.valueOf(15));
    }

    private Professor getProfessor()
    {

        Professor professor = new Professor();
        professor.setPersonnelId("professor#personnel#id");
        professor.setName("professor#name");
        professor.setSurname("professor#surname");
        professor.setNationalId("professor#national#id");

        Student student0 = new Student();
        student0.setStudentId("student0#id");
        student0.setName("student0#name");
        student0.setSurname("student0#surname");
        student0.setNationalId("student0#national#id");
        student0.setAddress("student0#address");


        Student student1 = new Student();


        Course course = new Course();
        course.setName("course#name");
        course.setCredit(3);


        CourseTaken taken0 = new CourseTaken();
        taken0.setStudent(student0);
        taken0.setCourse(course);
        taken0.setGrade(12);
        student0.addCourseTaken(taken0);

        CourseTaken taken1 = new CourseTaken();
        taken1.setStudent(student1);
        taken0.setCourse(course);
        taken1.setGrade(15);
        student1.addCourseTaken(taken1);

        CourseTaught taught = new CourseTaught();
        taught.setProfessor(professor);
        taught.setCourse(course);
        professor.addCourseTaught(taught);

        course.addCourseTaken(taken0);
        course.addCourseTaken(taken1);
        course.addCourseTaught(taught);


        return professor;
    }

}