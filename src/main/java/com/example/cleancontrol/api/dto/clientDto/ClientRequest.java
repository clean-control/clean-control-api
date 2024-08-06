package com.example.cleancontrol.api.dto.clientDto;

import java.sql.Date;


import lombok.Builder;
@Builder
public record ClientRequest(String name, String lastname, String nickname, String email, String password,
        String cpf, String phone, Date dateBirth, String imgUrl, Boolean active, Integer addressId) {

}
