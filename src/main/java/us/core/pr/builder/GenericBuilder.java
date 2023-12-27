package us.core.pr.builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GenericBuilder<T>
        implements IBuilder<T>
{
    private Class<T>            cClass;
    private Map<String, Object> properties;

    public GenericBuilder(Class<T> cClass)
    {
        this.cClass = cClass;
        this.properties = new HashMap<>();
    }

    public GenericBuilder<T> with(String property, Object value)
    {
        properties.put(property, value);
        return this;
    }

    @Override
    public T build()
//            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        T instance = null;
        try
        {
            instance = cClass.newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet())
            {
                String setterName = "set" + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1);
                Method setter = cClass.getMethod(setterName, entry.getValue().getClass());
                setter.invoke(instance, entry.getValue());
            }
        }
        catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
        return instance;
    }
}
