package us.core.pr.exception.service.college;

import us.core.pr.domain.entity.Professor;

public class ProfessorToCollegeAssignmentFailureException
        extends RuntimeException
{
    public ProfessorToCollegeAssignmentFailureException(Exception e)
    {
        super(e);
    }
}
