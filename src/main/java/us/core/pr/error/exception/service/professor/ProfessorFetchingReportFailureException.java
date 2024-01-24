package us.core.pr.error.exception.service.professor;

public class ProfessorFetchingReportFailureException
extends RuntimeException{
    public ProfessorFetchingReportFailureException(Exception e){
        super(e);
    }
}
