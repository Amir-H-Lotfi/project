package us.core.pr.exception.jpa.student;

import java.io.Serializable;

public class StudentEntityReadingFailureException
extends RuntimeException
implements Serializable
{
    public StudentEntityReadingFailureException(Exception e) {
        super(e);
    }
}
