package us.core.pr.domain.db.listeners.impl;

import us.core.pr.domain.db.entities.university.Professor;
import us.core.pr.domain.db.listeners.abstractions.abstracts.AbstractEntityListener;

import java.io.Serializable;

public class ProfessorEntityListener
        implements Serializable
{

    public static class ProfessorPreEntityListener
            extends AbstractEntityListener.PreEntityListener<Professor>
    {
        public ProfessorPreEntityListener()
        {
            super();
        }

        @Override
        public void persist(Professor professor)
        {

        }

        @Override
        public void remove(Professor professor)
        {

        }

        @Override
        public void update(Professor professor)
        {

        }
    }

    public static class ProfessorPostEntityListener
            extends AbstractEntityListener.PostEntityListener<Professor>
    {
        public ProfessorPostEntityListener()
        {
            super();
        }

        @Override
        public void persist(Professor professor)
        {

        }

        @Override
        public void remove(Professor professor)
        {

        }

        @Override
        public void update(Professor professor)
        {

        }

        @Override
        public void load(Professor professor)
        {

        }
    }
}
