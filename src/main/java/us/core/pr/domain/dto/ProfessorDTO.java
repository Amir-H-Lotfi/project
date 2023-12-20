package us.core.pr.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import us.core.pr.domain.entity.Professor;

import java.io.Serializable;

public enum ProfessorDTO
        implements Serializable
{
    ;


    @org.mapstruct.Mapper(componentModel = "spring")
    public interface Mapper
            extends Serializable
    {

    }
}
