package us.core.pr.resolver.argument.professor;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import us.core.pr.domain.dto.professor.Read;

import java.io.Serializable;

public class ReadResolver
        implements HandlerMethodArgumentResolver, Serializable
{
    @Override
    public boolean supportsParameter(MethodParameter methodParameter)
    {
        return methodParameter.getParameter().getType().isAssignableFrom(us.core.pr.domain.dto.professor.Read.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception
    {
        Read read = new Read();
        String personnelId = nativeWebRequest.getParameter("personnelId");
        String name = nativeWebRequest.getParameter("name");
        read.setPersonnelId(personnelId);
        read.setName(name);
        return read;
    }
}
