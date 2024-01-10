package us.core.pr.exception.jpa.college;

import us.core.pr.domain.entity.College;

import java.io.Serializable;

public class CollegeEntityRemovingFailureException
        extends RuntimeException
    implements Serializable
{
    public CollegeEntityRemovingFailureException(Exception e)
    {
        super(e);
    }
}
