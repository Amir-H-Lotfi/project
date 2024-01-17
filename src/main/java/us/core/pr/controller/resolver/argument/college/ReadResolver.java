package us.core.pr.controller.resolver.argument.college;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import us.core.pr.domain.dto.college.Read;

import java.io.Serializable;

public class ReadResolver
        implements HandlerMethodArgumentResolver, Serializable
{
    @Override
    public boolean supportsParameter(MethodParameter methodParameter)
    {
        return methodParameter.getParameter().getType().isAssignableFrom(us.core.pr.domain.dto.college.Read.class) ;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception
    {
        Read read = new Read() ;
        String name = nativeWebRequest.getParameter("name") ;
        read.setName(name);
        return read ;
    }
}
