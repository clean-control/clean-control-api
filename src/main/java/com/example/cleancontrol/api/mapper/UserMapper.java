package com.example.cleancontrol.api.mapper;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.userDto.UserTokenDto;
import com.example.cleancontrol.domain.model.Users;

@Component
public class UserMapper {
   
    
      

        public static UserTokenDto of(Users user, String token){
            // UserTokenDto userTokenDto = new UserTokenDto();

            // userTokenDto.userId(user.getId());
            // userTokenDto.email(user.getEmail());
            // userTokenDto.name(user.getName());
            // userTokenDto.token(token);


            UserTokenDto userTokenDto = new UserTokenDto(user.getId(), user.getName(), user.getEmail(), token);

            return userTokenDto;
        }

       

    
    
    }
    