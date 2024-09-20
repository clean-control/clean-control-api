package com.example.cleancontrol.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.clientDto.ClientRequest;
import com.example.cleancontrol.domain.model.Address;
import com.example.cleancontrol.domain.model.Client;
import com.example.cleancontrol.domain.model.Users;
import com.example.cleancontrol.domain.repository.AddressRepository;
import com.example.cleancontrol.domain.repository.ClientRepository;
import com.example.cleancontrol.domain.repository.UserRepository;
import com.example.cleancontrol.domain.repository.UserTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

        @Autowired
    PasswordEncoder passwordEncoder;

    public List<Client> findAll() {

        try {
            List<Client> clients = clientRepository.findAll();

            List<Client> lstClient = new ArrayList<Client>();

            for (Client client : clients) {
               
               if (client !=null && client.getUser() != null) {

                System.out.println(client.getUser());
                System.out.println(client.getId());
                lstClient.add(client);
                
               }

            }
            

            return lstClient;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar clientes: " + e.getMessage());
        }
    }

    public Client findById(Integer id) {
        try {
            if (id == null) {
                throw new NullPointerException();
            }

            Client client = clientRepository.findById(id).orElseThrow();
            return client;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar clientes: " + e.getMessage());
        }
    }

    public Client save(ClientRequest data) {
        try {

            if (data == null) {
                throw new NullPointerException();
            }

         Users user = new Users();

         String passwordEncrypted = passwordEncoder.encode(data.password());
 

            user.setName(data.name());
            user.setLastname(data.lastname());
            user.setNickname(data.nickname());
            user.setEmail(data.email());
            user.setPassword(passwordEncrypted);
            user.setCpf(data.cpf());
            user.setPhone(data.phone());
            user.setDateBirth(data.dateBirth());
            user.setImgUrl(data.imgUrl());
            user.setActive(data.active());
            user.setAddress(addressRepository.findById(data.addressId()).orElseThrow());

            user.setUserType(userTypeRepository.findByName("Client"));

            userRepository.save(user);

            Client client = new Client();
            client.setUser(user);

            

            clientRepository.save(client);

            return client;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
        }
    }
    public void activeClient(Integer id) {
        try {
            Client client = clientRepository.findById(id).orElseThrow();

            if (client == null) {
                throw new NullPointerException("Cliente não encontrado");
            }

            client.getUser().setActive(!client.getUser().getActive());

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

            if (client.getUser().getActive()) {

                client.getUser().setActive(false);
                clientRepository.save(client);
            } else {
                clientRepository.deleteById(id);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar cliente");
        }
    }

    public Client update(Integer id, ClientRequest data) {

        try {
            if (id == null || data == null) {
                throw new NullPointerException();
            }

            Client client = clientRepository.findById(id).orElseThrow();
Address address = addressRepository.findById(id).orElseThrow();
            client.getUser().setName(data.name() != null ? data.name() : client.getUser().getName());
            client.getUser().setLastname(data.lastname() != null ? data.lastname() : client.getUser().getLastname());
            client.getUser().setNickname(data.nickname() != null ? data.nickname() : client.getUser().getNickname());
            client.getUser().setEmail(data.email() != null ? data.email() : client.getUser().getEmail());
            client.getUser().setPassword(data.password() != null ? data.password() : client.getUser().getPassword());
            client.getUser().setCpf(data.cpf() != null ? data.cpf() : client.getUser().getCpf());
            client.getUser().setPhone(data.phone() != null ? data.phone() : client.getUser().getPhone());
            client.getUser().setDateBirth(data.dateBirth() != null ? data.dateBirth() : client.getUser().getDateBirth());
            client.getUser().setImgUrl(data.imgUrl() != null ? data.imgUrl() : client.getUser().getImgUrl());
            client.getUser().setActive(data.active() != null ? data.active() : client.getUser().getActive());
            client.getUser().setUserType(userTypeRepository.findById(data.userTypeId()).orElseThrow());
            client.getUser().setAddress(address != null ? address : client.getUser().getAddress());

            clientRepository.save(client);

            return client;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cliente");
        }
    }

}
