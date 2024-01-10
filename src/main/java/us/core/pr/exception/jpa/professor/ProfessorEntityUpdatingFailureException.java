package us.core.pr.exception.jpa.professor;

import java.io.Serializable;

public class ProfessorEntityUpdatingFailureException
        extends RuntimeException
    implements Serializable
{
    public ProfessorEntityUpdatingFailureException(Exception e)
    {
        super(e);
    }
}
