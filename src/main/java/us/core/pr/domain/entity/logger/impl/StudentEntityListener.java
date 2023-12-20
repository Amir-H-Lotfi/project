package us.core.pr.domain.entity.logger.impl;

import us.core.pr.domain.entity.Student;
import us.core.pr.domain.entity.logger.abstraction.AbstractEntityListener;

import java.io.Serializable;

public class StudentEntityListener
        implements Serializable
{
    public class StudentPreEntityListener
            extends AbstractEntityListener.PreEntityListener<Student>
    {
        public StudentPreEntityListener()
        {
            super();
        }
    }

    public class StudentPostEntityListener
            extends AbstractEntityListener.PostEntityListener<Student>
    {
        public StudentPostEntityListener()
        {
            super();
        }
    }
}
