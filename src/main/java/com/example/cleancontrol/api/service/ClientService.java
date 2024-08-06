package com.example.cleancontrol.api.service;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.clientDto.ClientRequest;
import com.example.cleancontrol.api.dto.clientDto.ClientResponse;
import com.example.cleancontrol.api.mapper.ClientMapper;
import com.example.cleancontrol.domain.model.Address;
import com.example.cleancontrol.domain.model.Client;
import com.example.cleancontrol.domain.repository.AddressRepository;
import com.example.cleancontrol.domain.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final AddressRepository addressRepository;

    public List<ClientResponse> findAll() {

        try {
            List<Client> clients = clientRepository.findAll();

            return clients.stream().map(clientMapper::toResponse).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar clientes");
        }
    }

    public ClientResponse findById(Integer id) {
        try {
            if (id == null) {
                throw new NullPointerException();
            }

            Client client = clientRepository.findById(id).orElseThrow();
            return clientMapper.toResponse(client);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar clientes");
        }
    }

    public ClientResponse save(ClientRequest data) {
        try {

            if (data == null) {
                throw new NullPointerException();
            }

            Client client = Client.builder()
                    .name(data.name())
                    .lastname(data.lastname())
                    .nickname(data.nickname())
                    .email(data.email())
                    .password(data.password())
                    .cpf(data.cpf())
                    .phone(data.phone())
                    .dateBirth(data.dateBirth())
                    .imgUrl(data.imgUrl())
                    .active(data.active())
                    .address(addressRepository.findById(data.addressId()).orElse(null))
                    .build();
            

            clientRepository.save(client);

            return clientMapper.toResponse(client);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar cliente");
        }
    }
    public void activeClient(Integer id) {
        try {
            Client client = clientRepository.findById(id).orElseThrow();

            if (client == null) {
                throw new NullPointerException("Cliente não encontrado");
            }

            client.setActive(!client.getActive());

            clientRepository.save(client);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ativar cliente");
        }
    }

    public void delete(Integer id) {
        try {
            Client client = clientRepository.findById(id).orElseThrow();

            if (client == null) {
                throw new NullPointerException("Cliente não encontrado");
            }

            if (client.getActive()) {

                client.setActive(false);
                clientRepository.save(client);
            } else {
                clientRepository.deleteById(id);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar cliente");
        }
    }

    public ClientResponse update(Integer id, ClientRequest data) {

        try {
            if (id == null || data == null) {
                throw new NullPointerException();
            }

            Client client = clientRepository.findById(id).orElseThrow();
Address address = addressRepository.findById(id).orElseThrow();
            client.setName(data.name() != null ? data.name() : client.getName());
            client.setLastname(data.lastname() != null ? data.lastname() : client.getLastname());
            client.setNickname(data.nickname() != null ? data.nickname() : client.getNickname());
            client.setEmail(data.email() != null ? data.email() : client.getEmail());
            client.setPassword(data.password() != null ? data.password() : client.getPassword());
            client.setCpf(data.cpf() != null ? data.cpf() : client.getCpf());
            client.setPhone(data.phone() != null ? data.phone() : client.getPhone());
            client.setDateBirth(data.dateBirth() != null ? data.dateBirth() : client.getDateBirth());
            client.setImgUrl(data.imgUrl() != null ? data.imgUrl() : client.getImgUrl());
            client.setActive(data.active() != null ? data.active() : client.getActive());
            client.setAddress(address != null ? address : client.getAddress());

            clientRepository.save(client);

            return clientMapper.toResponse(client);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cliente");
        }
    }

}
