package us.core.pr.exception.jpa.college;

import us.core.pr.domain.entity.College;

import java.io.Serializable;

public class CollegeEntityCreatingFailureException
        extends RuntimeException
    implements Serializable
{
    public CollegeEntityCreatingFailureException(Exception e)
    {
        super(e);
    }
}
