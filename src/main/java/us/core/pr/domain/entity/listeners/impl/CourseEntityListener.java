package us.core.pr.domain.entity.listeners.impl;

import us.core.pr.domain.entity.Course;
import us.core.pr.domain.entity.listeners.abstractions.abstracts.AbstractEntityListener;

import java.io.Serializable;

public class CourseEntityListener
        implements Serializable
{
    public static class CoursePreEntityListener
            extends AbstractEntityListener.PreEntityListener<Course>
    {
        public CoursePreEntityListener()
        {
            super();
        }

        @Override
        public void persist(Course course)
        {

        }

        @Override
        public void remove(Course course)
        {

        }

        @Override
        public void update(Course course)
        {

        }
    }

    public static class CoursePostEntityListener
            extends AbstractEntityListener.PostEntityListener<Course>
    {
        public CoursePostEntityListener()
        {
            super();
        }

        @Override
        public void persist(Course course)
        {

        }

        @Override
        public void remove(Course course)
        {

        }

        @Override
        public void update(Course course)
        {

        }

        @Override
        public void load(Course course)
        {

        }
    }
}
