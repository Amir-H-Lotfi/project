package us.core.pr.domain.entity.logger.impl;

import us.core.pr.domain.entity.College;
import us.core.pr.domain.entity.logger.abstraction.AbstractEntityListener;

import java.io.Serializable;

public class CollegeEntityListener
        implements Serializable
{
    private CollegeEntityListener() {}

    public class CollegePreEntityListener
            extends AbstractEntityListener.PreEntityListener<College>
    {
        public CollegePreEntityListener()
        {
            super();
        }

    }

    public class CollegePostEntityListener
            extends AbstractEntityListener.PostEntityListener<College>
    {
        public CollegePostEntityListener()
        {
            super();
        }
    }
}
