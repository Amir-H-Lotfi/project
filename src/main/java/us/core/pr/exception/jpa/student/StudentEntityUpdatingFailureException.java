package us.core.pr.exception.jpa.student;

import java.io.Serializable;

public class StudentEntityUpdatingFailureException
        extends RuntimeException
    implements Serializable
{
    public StudentEntityUpdatingFailureException(Exception e)
    {
        super(e);
    }
}
