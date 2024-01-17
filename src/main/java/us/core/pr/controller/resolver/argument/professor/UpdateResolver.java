package us.core.pr.controller.resolver.argument.professor;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import us.core.pr.domain.dto.professor.Update;

import java.io.Serializable;

public class UpdateResolver
        implements HandlerMethodArgumentResolver, Serializable
{
    @Override
    public boolean supportsParameter(MethodParameter methodParameter)
    {
        return methodParameter.getParameter().getType().isAssignableFrom(us.core.pr.domain.dto.professor.Update.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception
    {
        Update update = new Update();
        String personnelId = nativeWebRequest.getParameter("personnelId");
        update.setPersonnelId(personnelId);
        return update;
    }
}
