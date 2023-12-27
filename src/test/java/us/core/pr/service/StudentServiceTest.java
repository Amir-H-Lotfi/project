package us.core.pr.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.repository.IStudentRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest
{

    @Mock
    IDataTransferObjectMapperFactory factory;
    @Mock
    IStudentRepository               isRepository;
    @InjectMocks
    StudentService                   service;

    @Test
    void addCourse()
    {
    }

    @Test
    void getAverage()
    {
    }
}