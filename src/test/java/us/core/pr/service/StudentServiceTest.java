package us.core.pr.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.course.CreateToCourse;
import us.core.pr.domain.dto.reporting.RpStudentAVG;
import us.core.pr.domain.dto.student.Read;
import us.core.pr.domain.dto.student.Update;
import us.core.pr.domain.entity.Course;
import us.core.pr.domain.entity.CourseTaken;
import us.core.pr.domain.entity.Student;
import us.core.pr.repository.IStudentRepository;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class StudentServiceTest
{
    @Mock
    IDataTransferObjectMapperFactory factory;
    @Mock
    IStudentRepository               repository;
    @InjectMocks
    StudentService                   service;

    @Before
    public void initialize()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addCourse() throws Exception
    {
        Student student = getStudent();
        Create cCreate = new Create();
        cCreate.setName("course#name");
        cCreate.setCredit(3);

        Update sUpdate = new Update();
        sUpdate.setStudentId("student#id");

        Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.of(student));
        Mockito.when(factory.create(CreateToCourse.class)).thenReturn(new CreateToCourse());
        service.addCourse(sUpdate, cCreate);

        CourseTaken[] courseTakenSet = student.getCourseTaken().toArray(new CourseTaken[0]);

        Assertions.assertThat(courseTakenSet.length).isEqualTo(4);
//        Assertions.assertThat(courseTakenSet[0].getCourse().getName()).isEqualTo(cCreate.getName());
//        Assertions.assertThat(courseTakenSet[0].getCourse().getCredit()).isEqualTo(cCreate.getCredit());
        Assertions.assertThat(courseTakenSet[0].getStudent()).isEqualTo(student);
        Assertions.assertThat(courseTakenSet[0].getGrade()).isBetween(1, 20);

    }

    @Test
    public void getAverage()
    {
        Student student = getStudent();

        Read read = new Read();
        read.setStudentId("student#id");
        read.setName("student#name");

        Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.of(student));


        RpStudentAVG rp = service.getAverage(read);
        Assertions.assertThat(rp.getStudentId()).isEqualTo(student.getStudentId());
        Assertions.assertThat(rp.getName()).isEqualTo(student.getName());
        Assertions.assertThat(rp.getSurname()).isEqualTo(student.getSurname());
        Assertions.assertThat(rp.getAverage()).isBetween(BigDecimal.valueOf(15), BigDecimal.valueOf(16));
    }

    public static Student getStudent()
    {
        Student student = new Student();
        student.setStudentId("student#id");
        student.setName("student#name");
        student.setSurname("student#surname");
        student.setNationalId("student#national#id");


        Set<CourseTaken> courseTakenSet = new HashSet<>();
        courseTakenSet.add(new CourseTaken(12, student, new Course("Math", 3)));
        courseTakenSet.add(new CourseTaken(15, student, new Course("Operating System", 2)));
        courseTakenSet.add(new CourseTaken(20, student, new Course("Algorithm & Data Structure", 3)));
        student.setCourseTaken(courseTakenSet);

        return student;
    }
}