package us.core.pr.exception.jpa.college;

import java.io.Serializable;

public class CollegeEntityUpdatingFailureException
        extends RuntimeException
    implements Serializable
{
    public CollegeEntityUpdatingFailureException(Exception e)
    {
        super(e);
    }
}
