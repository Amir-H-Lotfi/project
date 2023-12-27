package us.core.pr.configuratoin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.core.pr.domain.crud.abstracts.AbstractCollegeJpaCrud;
import us.core.pr.domain.crud.abstracts.AbstractProfessorJpaCrud;
import us.core.pr.domain.crud.abstracts.AbstractStudentJpaCrud;
import us.core.pr.domain.crud.impl.ProfessorJpaCrud;
import us.core.pr.domain.dto.mapper.factory.impl.DefaultDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.repository.IStudentRepository;
import us.core.pr.domain.crud.impl.CollegeJpaCrud;
import us.core.pr.domain.crud.impl.StudentJpaCrud;

import java.io.Serializable;

@Configuration
public class BeanConfiguration
        implements Serializable
{
    @Bean
    public IDataTransferObjectMapperFactory factory()
    {
        return new DefaultDataTransferObjectMapperFactory();
    }

    @Bean
    public AbstractStudentJpaCrud abstractStudentJpaCrud(IStudentRepository repository,
            IDataTransferObjectMapperFactory factory)
    {
        return new StudentJpaCrud(repository, factory);
    }

    @Bean
    public AbstractCollegeJpaCrud abstractCollegeJpaCrud(ICollegeRepository repository,
            IDataTransferObjectMapperFactory factory)
    {
        return new CollegeJpaCrud(repository, factory);
    }

    @Bean
    public AbstractProfessorJpaCrud abstractProfessorJpaCrud(IProfessorRepository repository,
            IDataTransferObjectMapperFactory factory)
    {
        return new ProfessorJpaCrud(repository, factory);
    }
}
