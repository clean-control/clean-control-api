package com.example.cleancontrol.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancontrol.api.service.AuthenticationService;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService ;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/api/authenticate")
    public String authenticate(String username, String password) {
        return authenticationService.autenticate(username, password);
    }

    
}
