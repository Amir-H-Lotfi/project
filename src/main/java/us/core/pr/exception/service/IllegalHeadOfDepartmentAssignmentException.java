package us.core.pr.exception.service;

import java.io.Serializable;

public class IllegalHeadOfDepartmentAssignmentException
        extends RuntimeException
        implements Serializable
{
    public IllegalHeadOfDepartmentAssignmentException()
    {
        super();
    }

}
