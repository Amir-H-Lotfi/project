package us.core.pr.domain.dto.mapper.impl;

import us.core.pr.domain.dto.StudentDTO;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Student;

import java.io.Serializable;

public enum StudentDTOMapper
        implements Serializable
{
    ;

    public static class CreateToStudent
            implements IDataTransferObjectMapper<StudentDTO.Create, Student>
    {
        @Override
        public Student from(StudentDTO.Create source)
        {
            return null;
        }
    }

    public static class StudentToRead
            implements IDataTransferObjectMapper<Student , StudentDTO.Read>
    {

        @Override
        public StudentDTO.Read from(Student source)
        {
            return null;
        }
    }

    public static class UpdateToStudent
            implements IDataTransferObjectMapper<StudentDTO.Update, Student>
    {

        @Override
        public Student from(StudentDTO.Update source)
        {
            return null;
        }
    }

    public static class DeleteToStudent
            implements IDataTransferObjectMapper<StudentDTO.Delete, Student>
    {

        @Override
        public Student from(StudentDTO.Delete source)
        {
            return null;
        }
    }

}
