package us.core.pr.domain.entity.logger.abstraction;

import org.slf4j.Logger;

public abstract class AbstractEntityListener
{
    public static abstract class PreEntityListener<T>
            implements IEntityPreListener<T>
    {
        protected Logger logger;

        public PreEntityListener() {}

        public void setLogger(Logger logger)
        {
            this.logger = logger;
        }
    }

    public static abstract class PostEntityListener<T>
            implements IEntityPostListener<T>
    {
        protected Logger logger;

        public PostEntityListener() {}

        public void setLogger(Logger logger)
        {
            this.logger = logger;
        }
    }
}
