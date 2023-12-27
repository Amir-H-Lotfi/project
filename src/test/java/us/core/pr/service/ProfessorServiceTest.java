package us.core.pr.service;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.service.interfaces.IProfessorService;

import static org.junit.jupiter.api.Assertions.*;

public class ProfessorServiceTest
{
    @Mock
    IDataTransferObjectMapperFactory factory;
    @Mock
    IProfessorRepository             ipRepository;
    @InjectMocks
    ProfessorService                 service;

    @Test
    public void addCourse()
    {

    }

    @Test
    public void getAverage()
    {

    }
}