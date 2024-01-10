package us.core.pr.domain.entity.base;

import org.springframework.validation.ValidationUtils;
import us.core.pr.validation.annotation.Name;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.Validator;

@MappedSuperclass
public abstract class PersonEntity
        extends BaseEntity
{

    protected String name;
    protected String surname;
    protected String nationalId;


    @Name
    @Column(length = 48)
    public String getName()
    {
        Validator validator ;
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Name
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
}
