package com.example.cleancontrol.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.cleancontrol.api.dto.userDto.UserLoginDto;
import com.example.cleancontrol.api.dto.userDto.UserTokenDto;
import com.example.cleancontrol.api.mapper.ClientMapper;
import com.example.cleancontrol.api.security.GerenciadorTokenJwt;
import com.example.cleancontrol.domain.model.Users;
import com.example.cleancontrol.domain.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    UserRepository UserRepository;

    @Autowired
    ClientMapper clientMapper;

     @Autowired
    GerenciadorTokenJwt gerenciadorTokenJwt;
    @Autowired
    AuthenticationManager authenticationManager;

    public UserTokenDto authenticate(UserLoginDto clientLoginDTO) {

        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(clientLoginDTO.email() , clientLoginDTO.password());
        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Users clientAuthetication =
                UserRepository.findByEmail(clientLoginDTO.email())
        .orElseThrow(
                () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return clientMapper.of(clientAuthetication, token);
    }

}
