package com.example.cleancontrol.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.userDto.UserTokenDto;
import com.example.cleancontrol.api.dto.userDto.UsersDetailsDto;
import com.example.cleancontrol.domain.model.Users;
import com.example.cleancontrol.domain.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    System.out.println("chegou aqui: "+ username);
    
    Optional<Users> employeeOpt = userRepository.findByEmail(username);

    if (employeeOpt.isEmpty()) {
      System.out.println(String.format("Usuário: s? não encontrado", username));
      throw new UsernameNotFoundException(String.format("Usuário: s? não encontrado", username));
    }

    Users employee = employeeOpt.get();

    System.out.println("chegou aqui: "+ employee.getEmail() + " " + employee.getPassword()+ " " + employee.getName()); 

    UsersDetailsDto user= new UsersDetailsDto(employee.getName(), employee.getEmail(), employee.getPassword());


    System.out.println(user.getEmail());

    return user;

  }

}