package us.core.pr.security.provider;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DefaultAuthenticationProvider
        implements AuthenticationProvider
{
    private UserDetailsService service;
    private PasswordEncoder    passwordEncoder;

    public DefaultAuthenticationProvider(UserDetailsService service, PasswordEncoder passwordEncoder)
    {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = service.loadUserByUsername(username);
        if (passwordEncoder.matches(password, userDetails.getPassword()))
        {
            return new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(),
                    userDetails.getPassword(),
                    userDetails.getAuthorities()
            );
        }
        else throw new AuthenticationCredentialsNotFoundException("Credential Not Found");
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
