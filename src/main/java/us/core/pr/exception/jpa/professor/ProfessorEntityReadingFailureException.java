package us.core.pr.exception.jpa.professor;

import java.io.Serializable;

public class ProfessorEntityReadingFailureException
extends RuntimeException implements Serializable
{
    public ProfessorEntityReadingFailureException(Exception e) {
        super(e);
    }
}
