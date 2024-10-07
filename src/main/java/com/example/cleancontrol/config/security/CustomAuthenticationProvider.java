package com.example.cleancontrol.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.cleancontrol.api.service.AuthenticationService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(AuthenticationService authenticationService, PasswordEncoder passwordEncoder) {
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password =  authentication.getCredentials().toString();

        System.out.println(username);
        System.out.println(password);

        System.out.println("comecou aqui");
        UserDetails userDetails = authenticationService.loadUserByUsername(username);
        System.out.println("acabou aqui");

        if (userDetails == null) {
            System.out.println("entrou no if");
            throw new BadCredentialsException("Usuário ou senha inválidos");
        }

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            System.out.println("entrou no if 2");
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        } else {
            System.out.println("entrou no else");
            throw new BadCredentialsException("Usuário ou senha inválidos");
        }

        // System.out.println("entrou no if 2");
        // return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
