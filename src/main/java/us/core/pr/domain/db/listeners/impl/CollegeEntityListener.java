package us.core.pr.domain.db.listeners.impl;

import us.core.pr.domain.db.entities.university.College;
import us.core.pr.domain.db.listeners.abstractions.abstracts.AbstractEntityListener;

import java.io.Serializable;

public class CollegeEntityListener
        implements Serializable
{
    private CollegeEntityListener() {}

    public static class CollegePreEntityListener
            extends AbstractEntityListener.PreEntityListener<College>
    {
        public CollegePreEntityListener()
        {
            super();
        }

        @Override
        public void persist(College college)
        {

        }

        @Override
        public void remove(College college)
        {

        }

        @Override
        public void update(College college)
        {

        }
    }

    public static class CollegePostEntityListener
            extends AbstractEntityListener.PostEntityListener<College>
    {
        public CollegePostEntityListener()
        {
            super();
        }

        @Override
        public void persist(College college)
        {

        }

        @Override
        public void remove(College college)
        {

        }

        @Override
        public void update(College college)
        {

        }

        @Override
        public void load(College college)
        {

        }
    }
}
