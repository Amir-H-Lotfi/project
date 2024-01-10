package us.core.pr.exception.jpa.college;

import java.io.Serializable;

public class CollegeEntityReadingFailureException
        extends RuntimeException
    implements Serializable
{
    public CollegeEntityReadingFailureException(Exception e)
    {
        super(e);
    }
}
