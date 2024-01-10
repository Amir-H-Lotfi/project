package us.core.pr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;
import us.core.pr.domain.dto.course.Create;
import us.core.pr.domain.dto.reporting.RpStudentAVG;
import us.core.pr.domain.dto.student.Read;
import us.core.pr.domain.dto.student.Update;
import us.core.pr.service.impl.StudentService;

import java.net.URI;


@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource(locations = "classpath:application.yaml")
public class StudentControllerIntegrationTest
{
    UriComponentsBuilder uriBuilder;
    MockMvc              mockMvc;
    ObjectMapper         mapper;

    @Value("${server.port}")
    Integer port;
    @Value("${path.root}")
    String  root;
    @Value("${path.student.value}")
    String  student;

    @MockBean
    StudentService service;

    @Autowired
    WebApplicationContext context;


    @Before
    public void initialize()
    {
        Assertions.assertNotNull(context);
        MockitoAnnotations.initMocks(this);
        mapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        uriBuilder = UriComponentsBuilder.newInstance().scheme("http").host("localhost").port(port).encode();

    }

    @Test
    public void addCourse() throws Exception
    {
        URI uri = uriBuilder
                .pathSegment(root, student, "/courses")
                .queryParam("studentId", "studentId")
                .build()
                .toUri();

        Create course = new Create();
        course.setName("Math");
        course.setCredit(2);

        Mockito.doNothing()
               .when(service).addCourse(Mockito.any(Update.class), Mockito.any(Create.class));

        MockHttpServletRequestBuilder patch = MockMvcRequestBuilders
                .patch(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(course));


        mockMvc.perform(patch)
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAverage() throws Exception
    {
        URI uri = uriBuilder.pathSegment(root, student, "/courses/reports")
                            .queryParam("studentId", "studentId")
                            .queryParam("name", "studentName")
                            .build().toUri();
        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get(uri);

        Mockito.when(service.getAverage(Mockito.any(Read.class))).thenReturn(Mockito.any(RpStudentAVG.class));

        mockMvc.perform(get)
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(MockMvcResultHandlers.print());

    }


}