package us.core.pr.configuratoin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.factory.impl.DefaultDataTransferObjectMapperFactory;

import java.io.Serializable;
import java.util.*;

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
    public Collection<? extends HandlerMethodArgumentResolver> resolvers()
    {
        HandlerMethodArgumentResolver[] resolvers = new HandlerMethodArgumentResolver[]{
                new us.core.pr.controller.resolver.argument.professor.ReadResolver(),
                new us.core.pr.controller.resolver.argument.professor.UpdateResolver(),

                new us.core.pr.controller.resolver.argument.student.ReadResolver(),
                new us.core.pr.controller.resolver.argument.student.UpdateResolver(),

                new us.core.pr.controller.resolver.argument.college.ReadResolver()
        };
        return Arrays.asList(resolvers);
    }

}
