package us.core.pr.utils.builder;


import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class GenericBeanBuilder<T>
        implements IBuilder<T>
{

    private Class<T>            aClass;
    private Map<String, Object> properties;

    public GenericBeanBuilder(Class<T> aClass)
    {
        Assert.notNull(aClass);
        this.aClass = aClass;
        properties = new HashMap<>();
    }

    public GenericBeanBuilder<T> with(String propertyName, Object propertyValue)
    {
        Assert.notNull(propertyName);
        Assert.notNull(propertyValue);
        properties.put(propertyName, propertyValue);
        return this;
    }

    @Override
    public T build()
    {
        T instance;
        try
        {
            instance = aClass.newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet())
            {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, instance.getClass());
                Method setter = propertyDescriptor.getWriteMethod();
                setter.invoke(instance, fieldValue);
            }
        }
        catch (IllegalAccessException | InstantiationException | IntrospectionException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }

        return instance;
    }
}
