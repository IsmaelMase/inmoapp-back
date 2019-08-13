package com.inmboapp.clients.service;

import com.inmboapp.clients.model.ClientModel;

import java.util.Set;

public interface ClientService {
    Set<ClientModel> findAllClients();

    ClientModel findClientById(String id);

    ClientModel addClient(ClientModel clientModel);

    ClientModel updateClient(ClientModel clientModel);

    void removeClient(String id);
}
