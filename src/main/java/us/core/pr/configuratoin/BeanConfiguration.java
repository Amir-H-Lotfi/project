package us.core.pr.configuratoin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import us.core.pr.domain.crud.abstractions.abstracts.AbstractCollegeJpaCrud;
import us.core.pr.domain.crud.abstractions.abstracts.AbstractProfessorJpaCrud;
import us.core.pr.domain.crud.abstractions.abstracts.AbstractStudentJpaCrud;
import us.core.pr.domain.crud.impl.ProfessorJpaCrudOperations;
import us.core.pr.utils.mapper.factory.impl.DefaultDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.repository.IStudentRepository;
import us.core.pr.domain.crud.impl.CollegeJpaCrudOperations;
import us.core.pr.domain.crud.impl.StudentJpaCrudOperations;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

@Configuration
public class BeanConfiguration
        implements Serializable
{
    public BeanConfiguration() {}

    @Bean
    public IDataTransferObjectMapperFactory factory()
    {
        return new DefaultDataTransferObjectMapperFactory();
    }

    @Bean
    public AbstractStudentJpaCrud abstractStudentJpaCrud(IStudentRepository repository,
            IDataTransferObjectMapperFactory factory)
    {
        return new StudentJpaCrudOperations(repository, factory);
    }

    @Bean
    public AbstractCollegeJpaCrud abstractCollegeJpaCrud(ICollegeRepository repository,
            IDataTransferObjectMapperFactory factory)
    {
        return new CollegeJpaCrudOperations(repository, factory);
    }

    @Bean
    public AbstractProfessorJpaCrud abstractProfessorJpaCrud(IProfessorRepository repository,
            IDataTransferObjectMapperFactory factory)
    {
        return new ProfessorJpaCrudOperations(repository, factory);
    }

    @Bean
    public Collection<? extends HandlerMethodArgumentResolver> resolvers()
    {
        HandlerMethodArgumentResolver[] resolvers = new HandlerMethodArgumentResolver[]{
                new us.core.pr.resolver.argument.professor.ReadResolver(),
                new us.core.pr.resolver.argument.professor.UpdateResolver(),

                new us.core.pr.resolver.argument.student.ReadResolver(),
                new us.core.pr.resolver.argument.student.UpdateResolver(),

                new us.core.pr.resolver.argument.college.ReadResolver()
        };
        return Arrays.asList(resolvers);
    }

}
