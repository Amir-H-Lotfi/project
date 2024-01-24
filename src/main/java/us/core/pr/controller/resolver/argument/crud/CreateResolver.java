package us.core.pr.controller.resolver.argument.crud;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.io.Serializable;

public class CreateResolver
        implements HandlerMethodArgumentResolver, Serializable
{

    @Override
    public boolean supportsParameter(MethodParameter methodParameter)
    {
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception
    {
        return null;
    }
}
