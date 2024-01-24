package us.core.pr.domain.dto;

import us.core.pr.domain.db.entities.university.Professor;

import java.io.Serializable;

public class PersonDTO
        extends BaseDTO
        implements Serializable

{
    protected String name;
    protected String surname;

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
