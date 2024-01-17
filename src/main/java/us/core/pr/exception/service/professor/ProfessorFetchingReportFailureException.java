package us.core.pr.exception.service.professor;

public class ProfessorFetchingReportFailureException
extends RuntimeException{
    public ProfessorFetchingReportFailureException(Exception e){
        super(e);
    }
}
