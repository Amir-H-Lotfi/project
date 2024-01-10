package us.core.pr.exception.jpa.student;

import java.io.Serializable;

public class StudentEntityCreatingFailureException
        extends RuntimeException
    implements Serializable
{

    public StudentEntityCreatingFailureException(Exception e)
    {
        super(e);
    }
}
