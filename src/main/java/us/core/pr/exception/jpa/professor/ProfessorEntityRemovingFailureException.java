package us.core.pr.exception.jpa.professor;

import java.io.Serializable;

public class ProfessorEntityRemovingFailureException
        extends RuntimeException
    implements Serializable
{
    public ProfessorEntityRemovingFailureException(Exception e)
    {
        super(e);
    }
}
