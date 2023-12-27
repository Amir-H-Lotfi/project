package us.core.pr.domain.dto.mapper.impl;

import us.core.pr.domain.dto.CourseDTO;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Course;

import java.io.Serializable;

public enum CourseDTOMapper
        implements Serializable
{
    ;

    public static class CourseToCreate
            implements IDataTransferObjectMapper<Course, CourseDTO.Create>
    {

        @Override
        public CourseDTO.Create from(Course source)
        {
            CourseDTO.Create dto = new CourseDTO.Create();
            dto.setName(source.getName());
            dto.setCredit(source.getCredit());
            return dto;
        }
    }

    public static class CreateToCourse
            implements IDataTransferObjectMapper<CourseDTO.Create, Course>
    {
        @Override
        public Course from(CourseDTO.Create source)
        {
            Course course = new Course();
            course.setName(source.getName());
            course.setCredit(source.getCredit());
            return course;
        }
    }
}
