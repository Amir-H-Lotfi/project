package us.core.pr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import us.core.pr.domain.dto.college.Update;
import us.core.pr.domain.dto.professor.Read;
import us.core.pr.domain.dto.reporting.RpCollegeAVG;
import us.core.pr.service.CollegeService;
import us.core.pr.service.StudentService;
import us.core.pr.service.interfaces.ICollegeService;

import java.net.URI;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource(locations = "classpath:application.yaml")
public class CollegeControllerIntegrationTest
{
    MockMvc              mockMvc;
    UriComponentsBuilder uriBuilder;
    ObjectMapper         mapper;

    @Value("${server.port}")
    Integer port;
    @Value("${path.root}")
    String  root;
    @Value("${path.college.value}")
    String  college;

    @MockBean
    CollegeService        service;
    @Autowired
    WebApplicationContext context;

    @Before
    public void initialize()
    {
        Assertions.assertNotNull(context);

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        uriBuilder = UriComponentsBuilder.newInstance().scheme("http")
                                         .port(port).host("localhost")
                                         .encode();
        mapper = new ObjectMapper();
    }

    @Test
    public void addHeadOfDepartment() throws Exception
    {
        URI uri = uriBuilder.pathSegment(root, college, "hod")
                            .queryParam("personnelId", "professor#personnel#Id")
                            .queryParam("name", "professor#name")
                            .build().toUri();

        Update update = new Update();
        update.setName("Computer#College");

        MockHttpServletRequestBuilder patch = MockMvcRequestBuilders
                .patch(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(update));

        Mockito.doNothing().when(service).addProfessor(Mockito.any(Read.class), Mockito.any(Update.class));

        mockMvc.perform(patch)
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void addProfessor() throws Exception
    {
        URI uri = uriBuilder.pathSegment(root, college, "ap")
                            .queryParam("personnelId", "professor#personnel#id")
                            .queryParam("name", "professor#name")
                            .build().toUri();

        Update update = new Update();
        update.setName("Art#College");

        MockHttpServletRequestBuilder patch = MockMvcRequestBuilders
                .patch(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(update));

        Mockito.doNothing().when(service).addProfessor(Mockito.any(Read.class), Mockito.any(Update.class));

        mockMvc.perform(patch)
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAverage() throws Exception
    {
        URI uri = uriBuilder.pathSegment(root, college, "ga")
                            .queryParam("name", "college#name")
                            .build().toUri();

        us.core.pr.domain.dto.college.Read read = new us.core.pr.domain.dto.college.Read();
        read.setName("college#name");

        MockHttpServletRequestBuilder get = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(read));

        Mockito.when(service.getStudentsAverage(Mockito.any(us.core.pr.domain.dto.college.Read.class)))
               .thenReturn(Mockito.any(RpCollegeAVG.class));
        mockMvc.perform(get)
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(MockMvcResultHandlers.print());
    }


}
