package us.core.pr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import us.core.pr.domain.entity.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

}

