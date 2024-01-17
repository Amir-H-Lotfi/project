package us.core.pr.exception.service.college;

public class HeadOfDepartmentAssignmentFailureException
        extends RuntimeException
{
    public HeadOfDepartmentAssignmentFailureException(RuntimeException e)
    {
        super(e);
    }
}
