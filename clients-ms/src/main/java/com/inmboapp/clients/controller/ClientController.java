package com.inmboapp.clients.controller;

import com.inmboapp.clients.model.ClientModel;
import com.inmboapp.clients.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
@Api(tags = "clients-controller")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "findById/{id}")
    @ApiOperation(value = "Find client by id")
    public ClientModel getClientById(@PathVariable("id") String id) {
        return clientService.findClientById(id);
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "Find all clients")
    public Set<ClientModel> getAllClients() {
        return clientService.findAllClients();
    }

    @PostMapping(value = "/add")
    @ApiOperation(value = "Add client")
    public ResponseEntity addClient(@Valid @RequestBody ClientModel client) {
        return new ResponseEntity(clientService.addClient(client), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "Update client")
    public ResponseEntity updateClient(@Valid @RequestBody ClientModel client) {
        return new ResponseEntity(clientService.updateClient(client), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "Delete client")
    public ResponseEntity deleteClient(@PathVariable("id") String id) {
        clientService.removeClient(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
}
