package us.core.pr.domain.dto;

import java.io.Serializable;
import java.util.Set;

public enum ProfessorDTO
        implements Serializable
{
    ;

    public static class Create
            implements Serializable {}

    public static class Read
            implements Serializable
    {

        private String personnelId;
        private String name;

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
    }

    public static class Update
            implements Serializable
    {

        private String personnelId;

        public Update()
        {
        }

        public String getPersonnelId()
        {
            return personnelId;
        }

        public void setPersonnelId(String personnelId)
        {
            this.personnelId = personnelId;
        }
    }


    public static class Delete
            implements Serializable {}

}
