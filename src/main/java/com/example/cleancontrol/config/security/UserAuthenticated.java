package com.example.cleancontrol.config.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.cleancontrol.domain.model.Users;

public class UserAuthenticated implements UserDetails {

    private final Users user;


    public UserAuthenticated(Users user) {
        this.user = user;
    }

    
      @Override
      public String getUsername() {
        return user.getEmail();
      }
    
      @Override
      public String getPassword() {
        return user.getPassword();
      }
    
      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
      }
    
      @Override
      public boolean isAccountNonExpired() {
        return true;
      }
    
      @Override
      public boolean isAccountNonLocked() {
        return true;
      }
    
      @Override
      public boolean isCredentialsNonExpired() {
        return true;
      }
    
      @Override
      public boolean isEnabled() {
        return true;
      }
    
    }
    