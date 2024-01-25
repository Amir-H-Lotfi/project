package us.core.pr.security.userdetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import us.core.pr.domain.db.entities.security.Credential;

import java.util.*;
import java.util.stream.*;

public class DefaultUserDetails
        implements UserDetails

{
    private Credential credential;

    public DefaultUserDetails(Credential credential)
    {
        this.credential = credential;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Collection<SimpleGrantedAuthority> authorities = credential.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name())).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return credential.getPassword();
    }

    @Override
    public String getUsername()
    {
        return credential.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return credential.getAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return credential.getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return credential.getCredentialsExpired();
    }

    @Override
    public boolean isEnabled()
    {
        return credential.getEnabled();
    }
}
