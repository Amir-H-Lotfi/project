package us.core.pr.domain.dto;


import us.core.pr.builder.IBuilder;

import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.math.BigDecimal;
import java.util.stream.Stream;

public enum CollegeDTO
        implements Serializable
{
    ;

    public static class Create
            implements Serializable {}

    public static class Read
            implements Serializable
    {
        private String name;

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }
    }

    public static class Update
            implements Serializable
    {

        private String name;

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }
    }

    public static class Delete
            implements Serializable {}

    public static class CollegeAverage
            implements Serializable
    {
        private String     name;
        private BigDecimal students;
        private BigDecimal average;

        public CollegeAverage()
        {
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public BigDecimal getStudents()
        {
            return students;
        }

        public void setStudents(BigDecimal students)
        {
            this.students = students;
        }

        public BigDecimal getAverage()
        {
            return average;
        }

        public void setAverage(BigDecimal average)
        {
            this.average = average;
        }
    }
}
