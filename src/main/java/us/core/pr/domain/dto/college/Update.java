package us.core.pr.domain.dto.college;



import java.io.Serializable;

public class Update
        implements Serializable
{
    private String name;

    public Update()
    {

    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
