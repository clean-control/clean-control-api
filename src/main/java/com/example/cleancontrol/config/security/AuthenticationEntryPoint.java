package com.example.cleancontrol.config.security;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.exceptions.UnauthorizedException;
import com.example.cleancontrol.api.handler.GlobalExceptionHandler;

import java.io.IOException;

@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("{ \"error\": \"Unauthorized\",\"statusCode: 401\", \"message\": \"Usuário não autenticado ou token nao localizado\", \"path\": \"" + request.getRequestURI() + "\" }");
    }
}