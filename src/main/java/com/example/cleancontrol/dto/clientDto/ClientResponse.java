package com.example.cleancontrol.dto.clientDto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.example.cleancontrol.model.Address;

import lombok.Builder;

@Builder
public record ClientResponse(Integer id, String name, String lastname, String nickname, String email, String password,
        String cpf, String phone, Date dateBirth, String imgUrl, Boolean active, Address address,
        LocalDateTime createDate, LocalDateTime updateDate) {

}