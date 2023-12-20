package us.core.pr.domain.entity.logger.impl;

import us.core.pr.domain.entity.Professor;
import us.core.pr.domain.entity.logger.abstraction.AbstractEntityListener;

import java.io.Serializable;

public class ProfessorEntityListener
        implements Serializable
{

    public class ProfessorPreEntityListener
            extends AbstractEntityListener.PreEntityListener<Professor>
    {
        public ProfessorPreEntityListener()
        {
            super();
        }

    }

    public class ProfessorPostEntityListener
            extends AbstractEntityListener.PostEntityListener<Professor>
    {
        public ProfessorPostEntityListener()
        {
            super();
        }
    }
}
