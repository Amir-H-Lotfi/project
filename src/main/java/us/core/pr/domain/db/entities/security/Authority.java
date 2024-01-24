package us.core.pr.domain.db.entities.security;

import us.core.pr.domain.db.entities.base.BaseEntity;
import us.core.pr.domain.db.enums.Authorities;

import javax.persistence.*;
import java.util.*;

@SequenceGenerator(name = "default_generator", sequenceName = "ent_auth_seq", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "authority")
public class Authority
        extends BaseEntity
{
    private Authorities authorities;

    private Set<Credential> credentials;


    @Enumerated(EnumType.STRING)
    public Authorities getAuthorities()
    {
        return authorities;
    }

    public void setAuthorities(Authorities authorities)
    {
        this.authorities = authorities;
    }

    @ManyToMany
    @JoinTable(name = "users_authorities",
            joinColumns = @JoinColumn(name = "fk_authority_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_credentials_id"))
    public Set<Credential> getCredentials()
    {
        return credentials;
    }

    public void setCredentials(Set<Credential> credentials)
    {
        this.credentials = credentials;
    }
}
