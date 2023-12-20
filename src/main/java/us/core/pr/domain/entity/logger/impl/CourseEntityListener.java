package us.core.pr.domain.entity.logger.impl;

import us.core.pr.domain.entity.Course;
import us.core.pr.domain.entity.logger.abstraction.AbstractEntityListener;

import java.io.Serializable;

public class CourseEntityListener
        implements Serializable
{
    public class CoursePreEntityListener
            extends AbstractEntityListener.PreEntityListener<Course>
    {
        public CoursePreEntityListener()
        {
            super();
        }
    }

    public class CoursePostEntityListener
            extends AbstractEntityListener.PostEntityListener<Course>
    {
        public CoursePostEntityListener()
        {
            super();
        }

    }
}
