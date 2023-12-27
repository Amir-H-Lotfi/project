package us.core.pr.domain.dto.mapper.impl;

import us.core.pr.domain.dto.CollegeDTO;
import us.core.pr.domain.dto.CourseDTO;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;

import java.io.Serializable;

public enum CollegeDTOMapper
        implements Serializable
{
    ;


    public static class CreateToCollege
            implements IDataTransferObjectMapper<CollegeDTO.Create, College>
    {

        @Override
        public College from(CollegeDTO.Create source)
        {
            return null;
        }

    }

    public static class ReadToCollege
            implements IDataTransferObjectMapper<CollegeDTO.Read, College>
    {

        @Override
        public College from(CollegeDTO.Read source)
        {
            return null;
        }
    }

    public static class UpdateToCollege
            implements IDataTransferObjectMapper<CollegeDTO.Update, College>
    {

        @Override
        public College from(CollegeDTO.Update source)
        {
            return null;
        }

    }

    public static class DeleteToCollege
            implements IDataTransferObjectMapper<CollegeDTO.Delete, College>
    {

        @Override
        public College from(CollegeDTO.Delete source)
        {
            return null;
        }
    }

    public static class CollegeToRead
            implements IDataTransferObjectMapper<College, CollegeDTO.Read>
    {
        @Override
        public CollegeDTO.Read from(College source)
        {
            return null;
        }
    }
}
