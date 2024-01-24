package us.core.pr.domain.db.listeners.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.core.pr.domain.db.listeners.abstractions.abstracts.AbstractEntityListener;

import javax.persistence.*;
import java.io.Serializable;

public class EveryEntityListener
        implements Serializable
{
    private EveryEntityListener() {}

    public static class PreEveryEntityListener
            extends AbstractEntityListener.PreEntityListener<Object>
    {

        private final String prefix      = "PRE: ";
        private final String logTemplate = prefix + "Entity=%s, %s";

        public PreEveryEntityListener()
        {
            Logger logger = LoggerFactory.getLogger(getClass().getName());
            setLogger(logger);
        }

        @Override
        @PrePersist
        public void persist(Object o)
        {
            logger.warn(String.format(logTemplate, o.toString(), "persist"));
        }

        @Override
        @PreRemove
        public void remove(Object o)
        {
            logger.warn(String.format(logTemplate, o.toString(), "remove"));
        }

        @Override
        @PreUpdate
        public void update(Object o)
        {
            logger.warn(String.format(logTemplate, o.toString(), "update"));
        }
    }

    public static class PostEveryEntityListener
            extends AbstractEntityListener.PostEntityListener<Object>
    {

        private final String postfix     = "POST: ";
        private final String logTemplate = postfix + "Entity=%s, %s";

        public PostEveryEntityListener()
        {
            super();
            Logger logger = LoggerFactory.getLogger(getClass().getName());
            setLogger(logger);
        }

        @Override
        @PostPersist
        public void persist(Object o)
        {
            logger.warn(String.format(logTemplate, o.toString(), "persist"));
        }

        @Override
        @PostRemove
        public void remove(Object o)
        {
            logger.warn(String.format(logTemplate, o.toString(), "remove"));
        }

        @Override
        @PostUpdate
        public void update(Object o)
        {
            logger.warn(String.format(logTemplate, o.toString(), "update"));
        }

        @Override
        @PostLoad
        public void load(Object o)
        {
            logger.warn(String.format(logTemplate, o.toString(), "load"));
        }
    }
}
