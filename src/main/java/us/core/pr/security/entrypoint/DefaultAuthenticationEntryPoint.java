package us.core.pr.security.entrypoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import us.core.pr.security.dto.AuthenticationFailure;
import us.core.pr.utils.builder.GenericBeanBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class DefaultAuthenticationEntryPoint
        implements AuthenticationEntryPoint
{
    private ObjectMapper mapper;

    public DefaultAuthenticationEntryPoint()
    {
        mapper = new ObjectMapper();
    }

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            AuthenticationException e) throws IOException, ServletException
    {
        AuthenticationFailure failure = new GenericBeanBuilder<>(AuthenticationFailure.class)
                .with("timestamp", LocalDateTime.now())
                .with("status", HttpStatus.UNAUTHORIZED.value())
                .with("error", "Forbidden")
                .with("message", "Access Denied")
                .with("path", httpServletRequest.getContextPath().toString())
                .build();
        httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), mapper.writeValueAsString(failure));
    }

    public ObjectMapper getMapper()
    {
        return mapper;
    }

    public void setMapper(ObjectMapper mapper)
    {
        this.mapper = mapper;
    }
}
