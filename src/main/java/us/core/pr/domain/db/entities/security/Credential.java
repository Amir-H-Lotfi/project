package us.core.pr.domain.db.entities.security;

import us.core.pr.domain.db.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.*;

@SequenceGenerator(name = "default_generator", sequenceName = "ent_credentials_seq", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "credentials",
        indexes = {
                @Index(columnList = "username, password", unique = true),
                @Index(columnList = "username", unique = true)
        }
)
public class Credential
        extends BaseEntity

{
    private String  username;
    private String  password;
    private Boolean accountExpired;
    private Boolean credentialsExpired;
    private Boolean locked;
    private Boolean enabled;

    private Set<Role>      roles;
    private Set<Authority> authorities;

    @Column(length = 64)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Column(length = 64)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Column
    public Boolean getAccountExpired()
    {
        return accountExpired;
    }

    public void setAccountExpired(Boolean accountExpired)
    {
        this.accountExpired = accountExpired;
    }

    @Column
    public Boolean getCredentialsExpired()
    {
        return credentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired)
    {
        this.credentialsExpired = credentialsExpired;
    }

    @Column
    public Boolean getLocked()
    {
        return locked;
    }

    public void setLocked(Boolean locked)
    {
        this.locked = locked;
    }

    @Column
    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    @ManyToMany(mappedBy = "credentials", fetch = FetchType.EAGER)
    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    @ManyToMany(mappedBy = "credentials", fetch = FetchType.EAGER)
    public Set<Authority> getAuthorities()
    {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities)
    {
        this.authorities = authorities;
    }
}
