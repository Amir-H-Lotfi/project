package us.core.pr.exception.jpa.professor;

import java.io.Serializable;

public class ProfessorEntityCreatingFailureException
        extends RuntimeException
        implements Serializable
{
    public ProfessorEntityCreatingFailureException(Exception e)
    {
        super(e);
    }
}
