package com.example.cleancontrol.api.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public String autenticate(String username, String password) {
        return "token";
    }
}
