package us.core.pr.configuratoin;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import us.core.pr.security.entrypoint.DefaultAuthenticationEntryPoint;

import java.io.Serializable;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration
        extends WebSecurityConfigurerAdapter
        implements Serializable
{

    private UserDetailsService     userDetailsService;
    private PasswordEncoder        passwordEncoder;
    private AuthenticationProvider authenticationProvider;

    public SecurityConfiguration(@Qualifier("daoAuthenticationProvider") AuthenticationProvider authenticationProvider,
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder)
    {
        this.authenticationProvider = authenticationProvider;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {


        auth
                .authenticationProvider(authenticationProvider)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .httpBasic(httpSecurityHttpBasicConfigurer ->
                        {
                            httpSecurityHttpBasicConfigurer.authenticationEntryPoint(new DefaultAuthenticationEntryPoint());
                        }
                )
                .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests(expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .mvcMatchers("api/v1/university/**")
                        .hasAnyAuthority("ADMIN", "MANAGER")
                        .anyRequest().authenticated()
                )
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer.clearAuthentication(true).logoutSuccessUrl("/"));

    }
}
