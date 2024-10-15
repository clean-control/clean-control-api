package com.example.cleancontrol.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancontrol.api.dto.userDto.UserLoginDto;
import com.example.cleancontrol.api.dto.userDto.UserTokenDto;
import com.example.cleancontrol.api.service.UserService;


@RestController
public class AuthenticationController {

  @Autowired
  private UserService clientService;

  @PostMapping("/authentication")
    public ResponseEntity<UserTokenDto> login(@RequestBody UserLoginDto clientLoginDTO){
      UserTokenDto clientToken = this.clientService.authenticate(clientLoginDTO);
        return ResponseEntity.status(200).body(clientToken);
    }

}
