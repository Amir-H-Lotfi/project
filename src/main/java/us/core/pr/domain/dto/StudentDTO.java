package us.core.pr.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public enum StudentDTO
        implements Serializable
{
    ;

    public static class Create
            implements Serializable
    {
        private String studentId;
        private String name;
        private String surname;
        private String nationalId;
        private String address;

        public Create()
        {
        }

        public String getStudentId()
        {
            return studentId;
        }

        public void setStudentId(String studentId)
        {
            this.studentId = studentId;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getSurname()
        {
            return surname;
        }

        public void setSurname(String surname)
        {
            this.surname = surname;
        }

        public String getNationalId()
        {
            return nationalId;
        }

        public void setNationalId(String nationalId)
        {
            this.nationalId = nationalId;
        }

        @JsonIgnore
        public String getAddress()
        {
            return address;
        }

        public void setAddress(String address)
        {
            this.address = address;
        }
    }

    public static class Read
            implements Serializable
    {
        private String studentId;
        private String name;


        public String getStudentId()
        {
            return studentId;
        }

        public void setStudentId(String studentId)
        {
            this.studentId = studentId;
        }

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
        private String studentId;

        public Update() {}

        public String getStudentId()
        {
            return studentId;
        }

        public void setStudentId(String studentId)
        {
            this.studentId = studentId;
        }
    }

    public static class Delete
            implements Serializable
    {

    }

    public static class StudentAverage
            implements Serializable
    {
        private String     studentId;
        private String     name;
        private BigDecimal average;

        public String getStudentId()
        {
            return studentId;
        }

        public void setStudentId(String studentId)
        {
            this.studentId = studentId;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
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
