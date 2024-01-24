package us.core.pr.configuratoin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import us.core.pr.security.provider.DefaultAuthenticationProvider;

import java.io.Serializable;

@Configuration
public class SecurityBeanConfiguration
        implements Serializable
{
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService , PasswordEncoder passwordEncoder)
    {
        return new DefaultAuthenticationProvider(userDetailsService , passwordEncoder);
    }

}
