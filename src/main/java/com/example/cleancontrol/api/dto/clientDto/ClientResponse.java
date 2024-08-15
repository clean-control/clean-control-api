package com.example.cleancontrol.api.dto.clientDto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.Address;
import com.example.cleancontrol.domain.model.UserType;

import lombok.Builder;

@Builder
public record ClientResponse(Integer id, String name, String lastname, String nickname, String email, String password,
        String cpf, String phone, Date dateBirth, String imgUrl, Boolean active, Address address, UserType userType,
        LocalDateTime createDate, LocalDateTime updateDate) {

}