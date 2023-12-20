package us.core.pr.configuratoin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.io.Serializable;

@Configuration
public class BeanValidationConfiguration
        implements Serializable
{
    public BeanValidationConfiguration() {}

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean()
    {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {

        MethodValidationPostProcessor validation = new MethodValidationPostProcessor();
        validation.setAdaptConstraintViolations(Boolean.TRUE);
        return validation;
    }


}
