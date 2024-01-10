package us.core.pr.utils.builder;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public interface IBuilder<T>
        extends Serializable
{
    T build();
}
