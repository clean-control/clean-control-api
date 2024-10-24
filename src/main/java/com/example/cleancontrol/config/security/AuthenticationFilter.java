package com.example.cleancontrol.config.security;


import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.cleancontrol.api.exceptions.UnauthorizedException;
import com.example.cleancontrol.api.service.AuthenticationService;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);
    private final AuthenticationService authenticationService;
    private final GerenciadorTokenJwt jwtTokenManager;

    public AuthenticationFilter(AuthenticationService authenticationService, GerenciadorTokenJwt jwtTokenManager) {
        this.authenticationService = authenticationService;
        this.jwtTokenManager = jwtTokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = null;
        String jwtToken = null;
    
        String requestTokenHeader = request.getHeader("Authorization");
    
        if (Objects.nonNull(requestTokenHeader) && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtTokenManager.getUsernameFromToken(jwtToken);
            } catch (ExpiredJwtException exception) {
                LOGGER.info("[FALHA AUTENTICACAO] - Token expirado, usuario: {} - {}",
                        exception.getClaims().getSubject(), exception.getMessage());
    
                // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token exp");
                
                throw new UnauthorizedException(requestTokenHeader);
            }
        }
    
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            addUsernameInContext(request, username, jwtToken);
        }
        filterChain.doFilter(request, response);
    }
    

            private void addUsernameInContext(HttpServletRequest request, String username, String jwtToken) {
                UserDetails userDetails = authenticationService.loadUserByUsername(username);

                if (jwtTokenManager.validateToken( jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new
                            UsernamePasswordAuthenticationToken(
                                    userDetails, null, userDetails.getAuthorities());
                            usernamePasswordAuthenticationToken
                                    .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext( ).setAuthentication( usernamePasswordAuthenticationToken);
        }
    }

  
}
