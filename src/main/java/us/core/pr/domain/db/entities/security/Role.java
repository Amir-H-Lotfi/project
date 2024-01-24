package us.core.pr.domain.db.entities.security;

import us.core.pr.domain.db.entities.base.BaseEntity;
import us.core.pr.domain.db.enums.Roles;

import javax.persistence.*;
import java.util.*;

@SequenceGenerator(name = "default_generator", sequenceName = "ent_role_seq", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "role")
public class Role
        extends BaseEntity
{
    private Roles role;

    private Set<Credential> credentials;

    @Enumerated(EnumType.STRING)
    public Roles getRole()
    {
        return role;
    }

    public void setRole(Roles role)
    {
        this.role = role;
    }

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "fk_role_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_credential_id"))
    public Set<Credential> getCredentials()
    {
        return credentials;
    }

    public void setCredentials(Set<Credential> credential)
    {
        this.credentials = credential;
    }
}
