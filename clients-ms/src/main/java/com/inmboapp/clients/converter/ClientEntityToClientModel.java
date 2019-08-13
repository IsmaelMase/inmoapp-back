package com.inmboapp.clients.converter;

import com.inmboapp.clients.entity.ClientEntity;
import com.inmboapp.clients.model.ClientModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClientEntityToClientModel implements Function<ClientEntity, ClientModel> {
    @Override
    public ClientModel apply(ClientEntity clientEntity) {
        return ClientModel.builder()
                .id(clientEntity.getId())
                .dni(clientEntity.getDni())
                .name(clientEntity.getName())
                .subname(clientEntity.getSubname())
                .emailContact(clientEntity.getEmailContact())
                .phoneContact(clientEntity.phoneContact)
                .address(clientEntity.getAddress()).build();
    }
}
