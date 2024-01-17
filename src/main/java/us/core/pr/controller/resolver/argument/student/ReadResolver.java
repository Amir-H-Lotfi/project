package us.core.pr.controller.resolver.argument.student;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import us.core.pr.domain.dto.student.Read;

import java.io.Serializable;

public class ReadResolver
        implements HandlerMethodArgumentResolver, Serializable
{
    @Override
    public boolean supportsParameter(MethodParameter methodParameter)
    {
        return methodParameter.getParameter().getType().isAssignableFrom(us.core.pr.domain.dto.student.Read.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception
    {
        Read read = new Read();
        String studentId = nativeWebRequest.getParameter("studentId");
        String name = nativeWebRequest.getParameter("name");
        read.setStudentId(studentId);
        read.setName(name);
        return read;
    }
}
