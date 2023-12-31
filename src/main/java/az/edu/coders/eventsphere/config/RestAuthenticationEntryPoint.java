package az.edu.coders.eventsphere.config;

import az.edu.coders.eventsphere.error.RestErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        RestErrorResponse restErrorResponse = new RestErrorResponse();
        restErrorResponse.setMessage(authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, objectMapper.writeValueAsString(restErrorResponse));
    }
}