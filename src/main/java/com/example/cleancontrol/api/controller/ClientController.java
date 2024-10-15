package com.example.cleancontrol.api.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancontrol.api.dto.clientDto.ClientRequest;
import com.example.cleancontrol.api.dto.clientDto.ClientResponse;
import com.example.cleancontrol.api.mapper.ClientMapper;
import com.example.cleancontrol.api.service.ClientService;
import com.example.cleancontrol.domain.model.Client;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
        private final ClientMapper clientMapper;


    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClient(){
        List<ClientResponse> clientRes =  new ArrayList();

          try {
            List<Client> clients = clientService.findAll();
            for (Client client : clients) {
                System.out.println(client.getUser());

                ClientResponse clientResponse = clientMapper.toResponse(client.getUser());
                clientRes.add(clientResponse);
            }
            return ResponseEntity.ok(clientRes);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable Integer id){
        try {
            ClientResponse client = clientMapper.toResponse(clientService.findById(id).getUser());
            return ResponseEntity.ok(client);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClientResponse> saveClient(@RequestBody ClientRequest data){
        try {
            ClientResponse client = clientMapper.toResponse(clientService.save(data).getUser());
            return ResponseEntity.ok(client);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable Integer id, @RequestBody ClientRequest data){
        try {
            ClientResponse client = clientMapper.toResponse(clientService.update(id, data).getUser());
            return ResponseEntity.ok(client);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id){
        try {
            clientService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/active/{id}")
    public ResponseEntity<Void> activeClient(@PathVariable Integer id){
        try {
            clientService.activeClient(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }
}
