package com.example.cleancontrol.api.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.clientDto.ClientRequest;
import com.example.cleancontrol.api.dto.clientDto.ClientResponse;
import com.example.cleancontrol.domain.model.Client;

@Component
public class ClientMapper {


    public ClientResponse toResponse(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .lastname(client.getLastname())
                .nickname(client.getNickname())
                .email(client.getEmail())
                .password(client.getPassword())
                .cpf(client.getCpf())
                .phone(client.getPhone())
                .dateBirth(client.getDateBirth())
                .imgUrl(client.getImgUrl())
                .active(client.getActive())
                .address(client.getAddress())
                .createDate(client.getCreateDate())
                .updateDate(client.getUpdateDate())
                .build();
    }

    public List<ClientResponse> toResponse(List<Client> client) {
        return client.stream().map(this::toResponse).collect(Collectors.toList());
    }


}
