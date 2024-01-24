package us.core.pr.domain.db.entities.base;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity
        implements Serializable
{
    protected Integer id;

    public BaseEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "default_generator")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}
