package us.core.pr.configuratoin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

@Configuration
public class WebConfiguration
        implements WebMvcConfigurer
{
    private final Collection<? extends HandlerMethodArgumentResolver> resolvers;

    public WebConfiguration(Collection<? extends HandlerMethodArgumentResolver> resolvers) {this.resolvers = resolvers;}

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers)
    {
        resolvers.addAll(this.resolvers);
    }
}
