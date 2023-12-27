package us.core.pr.domain.dto.mapper.factory.impl;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import us.core.pr.domain.dto.CollegeDTO;
import us.core.pr.domain.dto.mapper.impl.CollegeDTOMapper;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;

public class DefaultDataTransferObjectMapperFactoryTest
{
    DefaultDataTransferObjectMapperFactory factory = new DefaultDataTransferObjectMapperFactory();

    @Test
    public void createMapper()
            throws Exception
    {
        IDataTransferObjectMapper<CollegeDTO.Update, College> mapper = factory.create(CollegeDTOMapper.UpdateToCollege.class);
        Assertions.assertNotNull(mapper);
        Assertions.assertTrue(mapper instanceof CollegeDTOMapper.UpdateToCollege);
    }
}