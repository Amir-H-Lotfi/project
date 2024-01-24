package us.core.pr.domain.db.entities.base;

import us.core.pr.domain.db.entities.security.Credential;
import us.core.pr.validation.annotation.Address;
import us.core.pr.validation.annotation.Name;

import javax.persistence.*;
import javax.validation.Validator;

@SequenceGenerator(name = "default_generator", sequenceName = "ent_personnel_seq", initialValue = 1, allocationSize = 1)
@Table(name = "personnel", indexes = {
        @Index(columnList = "nationalId"),
        @Index(columnList = "address")
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personnel
        extends BaseEntity
{

    protected String name;
    protected String surname;
    protected String nationalId;
    protected String address;

    // relation
    protected Credential credential;


    @Name(message = "Invalid Name")
    @Column(length = 48)
    public String getName()
    {
        Validator validator;
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Name(message = "Invalid Surname")
    @Column(length = 48)
    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    @Column(length = 48)
    public String getNationalId()
    {
        return nationalId;
    }

    public void setNationalId(String nationalId)
    {
        this.nationalId = nationalId;
    }

    @Address(message = "Invalid Address")
    @Column(length = 128)
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_personnel_id")
    public Credential getCredential()
    {
        return credential;
    }

    public void setCredential(Credential credential)
    {
        this.credential = credential;
    }
}
