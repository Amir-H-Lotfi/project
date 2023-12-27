package us.core.pr.domain.dto.mapper.impl;

import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Professor;

import java.io.Serializable;

public enum ProfessorDTOMapper
        implements Serializable
{
    ;

    public static class UpdateToProfessor
            implements IDataTransferObjectMapper<ProfessorDTO.Update, Professor>
    {
        @Override
        public Professor from(ProfessorDTO.Update source)
        {
            return null;
        }
    }

    public static class CreateToProfessor
            implements IDataTransferObjectMapper<ProfessorDTO.Create, Professor>
    {

        @Override
        public Professor from(ProfessorDTO.Create source)
        {
            return null;
        }
    }

    public static class ProfessorToRead
            implements IDataTransferObjectMapper<Professor, ProfessorDTO.Read>
    {
        @Override
        public ProfessorDTO.Read from(Professor source)
        {
            return null;
        }
    }

    public static class DeleteToProfessor
            implements IDataTransferObjectMapper<ProfessorDTO.Delete, Professor>
    {

        @Override
        public Professor from(ProfessorDTO.Delete source)
        {
            return null;
        }
    }

    public static class ReadToProfessor
            implements IDataTransferObjectMapper<ProfessorDTO.Read, Professor>
    {

        @Override
        public Professor from(ProfessorDTO.Read source)
        {
            return null;
        }
    }
}
