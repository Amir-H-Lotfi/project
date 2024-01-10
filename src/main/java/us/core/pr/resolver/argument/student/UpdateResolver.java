package us.core.pr.resolver.argument.student;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import us.core.pr.domain.dto.student.Update;

import java.io.Serializable;

public class UpdateResolver
        implements HandlerMethodArgumentResolver, Serializable
{

    @Override
    public boolean supportsParameter(MethodParameter methodParameter)
    {
        return methodParameter.getParameter().getType().isAssignableFrom(us.core.pr.domain.dto.student.Update.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception
    {
        Update update = new Update();
        String studentId = nativeWebRequest.getParameter("studentId");
        update.setStudentId(studentId);
        return update;
    }
}
