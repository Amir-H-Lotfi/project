package us.core.pr.domain.dto;

import us.core.pr.builder.IBuilder;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public enum ReportingDTO
        implements Serializable
{
    ;

    public static class RpProfessorAVG
            implements Serializable
    {

        public static class Builder
                implements IBuilder<RpProfessorAVG>
        {
            private RpProfessorAVG rpProfessorAVG;

            public Builder()
            {
                rpProfessorAVG = new RpProfessorAVG();
            }

            public Builder personnelId(String personnelId)
            {
                rpProfessorAVG.personnelId = personnelId;
                return this;
            }

            public Builder name(String name)
            {
                rpProfessorAVG.name = name;
                return this;
            }

            public Builder averageReports(Set<RpCourseTaught> averageReports)
            {
                rpProfessorAVG.averageReports = averageReports;
                return this;
            }

            @Override
            public RpProfessorAVG build()
            {
                return rpProfessorAVG;
            }
        }

        private String              personnelId;
        private String              name;
        private Set<RpCourseTaught> averageReports;

        public RpProfessorAVG()
        {
            this.averageReports = new HashSet<>();
        }

        public String getPersonnelId()
        {
            return personnelId;
        }

        public void setPersonnelId(String personnelId)
        {
            this.personnelId = personnelId;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public Set<RpCourseTaught> getAverageReports()
        {
            return averageReports;
        }

        public void setAverageReports(Set<RpCourseTaught> averageReports)
        {
            this.averageReports = averageReports;
        }

        public void addAverageReports(RpCourseTaught entity)
        {
            this.averageReports.add(entity);
        }
    }

    public static class RpCourseTaught
            implements Serializable
    {
        public static class Builder
                implements IBuilder<RpCourseTaught>
        {
            private RpCourseTaught rpCourseTaught;

            public Builder()
            {
                rpCourseTaught = new RpCourseTaught();
            }

            public Builder courseName(String courseName)
            {
                rpCourseTaught.courseName = courseName;
                return this;
            }

            public Builder average(BigDecimal average)
            {
                rpCourseTaught.average = average;
                return this;
            }

            @Override
            public RpCourseTaught build()
            {
                return rpCourseTaught;
            }
        }

        private String     courseName;
        private BigDecimal average;

        public RpCourseTaught()
        {
        }

        public String getCourseName()
        {
            return courseName;
        }

        public void setCourseName(String courseName)
        {
            this.courseName = courseName;
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

    public static class RpStudentAVG
            implements Serializable
    {

        public static class Builder
                implements IBuilder<RpStudentAVG>
        {
            private RpStudentAVG rpStudentAVG;

            public Builder()
            {
                rpStudentAVG = new RpStudentAVG();
            }

            public Builder studentId(String studentId)
            {
                rpStudentAVG.studentId = studentId;
                return this;
            }

            public Builder name(String name)
            {
                rpStudentAVG.name = name;
                return this;
            }

            public Builder average(BigDecimal average)
            {
                rpStudentAVG.average = average;
                return this;
            }

            @Override
            public RpStudentAVG build()
            {
                return rpStudentAVG;
            }
        }

        private String     studentId;
        private String     name;
        private BigDecimal average;

        public RpStudentAVG()
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

        public BigDecimal getAverage()
        {
            return average;
        }

        public void setAverage(BigDecimal average)
        {
            this.average = average;
        }
    }

    public static class RpCollegeAVG
            implements Serializable
    {
        public static class Builder
                implements IBuilder<RpCollegeAVG>
        {
            private RpCollegeAVG rpCollegeAVG;

            public Builder()
            {
                rpCollegeAVG = new RpCollegeAVG();
            }

            public Builder name(String name)
            {
                rpCollegeAVG.name = name;
                return this;
            }

            public Builder students(BigDecimal students)
            {
                rpCollegeAVG.students = students;
                return this;
            }

            public Builder average(BigDecimal average)
            {
                rpCollegeAVG.average = average;
                return this;
            }

            @Override
            public RpCollegeAVG build()
            {
                return rpCollegeAVG;
            }
        }

        private String     name;
        private BigDecimal students;
        private BigDecimal average;

        public RpCollegeAVG()
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
