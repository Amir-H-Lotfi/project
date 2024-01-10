package us.core.pr.domain.entity.listener.impl;

import us.core.pr.domain.entity.Professor;
import us.core.pr.domain.entity.listener.abstractions.abstracts.AbstractEntityListener;

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
