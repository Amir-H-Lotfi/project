package us.core.pr.exception.jpa.student;

import java.io.Serializable;

public class StudentEntityRemovingFailureException
        extends RuntimeException
    implements Serializable
{
    public StudentEntityRemovingFailureException(Exception e)
    {
        super(e);
    }
}
