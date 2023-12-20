package us.core.pr.exception;

import java.io.Serializable;

public class IllegalHeadOfDepartmentAssignmentException
        extends RuntimeException
        implements Serializable
{
    public IllegalHeadOfDepartmentAssignmentException()
    {
        super();
    }

    public IllegalHeadOfDepartmentAssignmentException(String message)
    {
        super(message);
    }
}
