package com.example.cleancontrol.api.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.clientDto.ClientResponse;
import com.example.cleancontrol.domain.model.Client;
import com.example.cleancontrol.domain.model.User;

@Component
public class ClientMapper {


    public ClientResponse toResponse(User user) {
        return ClientResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastname())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .cpf(user.getCpf())
                .phone(user.getPhone())
                .dateBirth(user.getDateBirth())
                .imgUrl(user.getImgUrl())
                .active(user.getActive())
                .address(user.getAddress())
                .build();
    }

    
    public List<ClientResponse> toResponse(List<User> users) {
        return users.stream().map(this::toResponse).collect(Collectors.toList());
    }


}
