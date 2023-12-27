package us.core.pr.domain.entity.listener.impl;

import us.core.pr.domain.entity.Student;
import us.core.pr.domain.entity.listener.abstracts.AbstractEntityListener;

import java.io.Serializable;

public class StudentEntityListener
        implements Serializable
{
    public static class StudentPreEntityListener
            extends AbstractEntityListener.PreEntityListener<Student>
    {
        public StudentPreEntityListener()
        {
            super();
        }

        @Override
        public void persist(Student student)
        {

        }

        @Override
        public void remove(Student student)
        {

        }

        @Override
        public void update(Student student)
        {

        }
    }

    public static class StudentPostEntityListener
            extends AbstractEntityListener.PostEntityListener<Student>
    {
        public StudentPostEntityListener()
        {
            super();
        }

        @Override
        public void persist(Student student)
        {

        }

        @Override
        public void remove(Student student)
        {

        }

        @Override
        public void update(Student student)
        {

        }

        @Override
        public void load(Student student)
        {

        }
    }
}
