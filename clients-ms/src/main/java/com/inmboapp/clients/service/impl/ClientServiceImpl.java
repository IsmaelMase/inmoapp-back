package com.inmboapp.clients.service.impl;

import com.inmboapp.clients.converter.ClientEntityToClientModel;
import com.inmboapp.clients.converter.ClientModelToClientEntity;
import com.inmboapp.clients.entity.ClientEntity;
import com.inmboapp.clients.model.ClientModel;
import com.inmboapp.clients.model.exception.ClientDniAlReadyExist;
import com.inmboapp.clients.model.exception.ClientNotFound;
import com.inmboapp.clients.repository.ClientRepository;
import com.inmboapp.clients.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientEntityToClientModel clientEntityToClientModel;

    private final ClientModelToClientEntity clientModelToClientEntity;

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientEntityToClientModel clientEntityToClientModel, ClientModelToClientEntity clientModelToClientEntity, ClientRepository clientRepository) {
        this.clientEntityToClientModel = clientEntityToClientModel;
        this.clientModelToClientEntity = clientModelToClientEntity;
        this.clientRepository = clientRepository;
    }

    @Override
    public Set<ClientModel> findAllClients() {
        return clientRepository.findAll().stream().map(clientEntityToClientModel).collect(Collectors.toSet());
    }

    @Override
    public ClientModel findClientById(String id) {
        return clientRepository.findById(id).map(clientEntityToClientModel).orElseThrow(() -> new ClientNotFound(id));
    }

    @Override
    public ClientModel addClient(ClientModel clientModel) {
        clientModel.setId("");
        clientExistByDni(clientModel.getDni(), null);

        ClientEntity clientEntity = clientRepository.save(clientModelToClientEntity.apply(clientModel));

        return clientEntityToClientModel.apply(clientEntity);
    }

    @Override
    public ClientModel updateClient(ClientModel clientModel) {
        existClientById(clientModel.getId());
        clientExistByDni(clientModel.getDni(), clientModel.getId());

        ClientEntity clientEntity = clientRepository.save(clientModelToClientEntity.apply(clientModel));

        return clientEntityToClientModel.apply(clientEntity);
    }

    @Override
    public void removeClient(String id) {
        clientRepository.deleteById(id);
    }

    private void clientExistByDni(String dni, String clientId) {
        if (clientId == null) {
            Optional<ClientEntity> existByDni = clientRepository.findClientByDni(dni);
            if (existByDni.isPresent()) {
                throw new ClientDniAlReadyExist(dni);
            }
        } else {
            Optional<ClientEntity> existByDni = clientRepository.findClientByDni(dni);
            if (existByDni.isPresent()) {
                if (!existByDni.get().getId().equals(clientId)) {
                    throw new ClientDniAlReadyExist(dni);
                }
            }
        }
    }

    private void existClientById(String clientId) {
        Optional<ClientEntity> existById = clientRepository.findById(clientId);
        if (!existById.isPresent()) {
            throw new ClientNotFound(clientId);
        }
    }

}
