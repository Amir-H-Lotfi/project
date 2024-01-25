package us.core.pr.domain.dto.base;

import java.io.Serializable;

public class PersonDTO
        implements Serializable

{
    protected String name;
    protected String surname;
    protected String address;
    protected String nationalId;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }
}
