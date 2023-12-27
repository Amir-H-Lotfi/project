package us.core.pr.service;

import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.repository.ICollegeRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CollegeServiceTest
{
    @Mock
    IDataTransferObjectMapperFactory factory;
    @Mock
    ICollegeRepository               icRepository;
    @InjectMocks
    CollegeService                   service;


    @Test
    public void addHeadOfDepartment() {

    }

    @Test
    public void addProfessor() {

    }
    @Test
    public void getStudentAverage() {

    }


}