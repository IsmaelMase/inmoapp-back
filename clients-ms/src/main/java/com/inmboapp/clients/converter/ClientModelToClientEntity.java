package com.inmboapp.clients.converter;

import com.inmboapp.clients.entity.ClientEntity;
import com.inmboapp.clients.model.ClientModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClientModelToClientEntity implements Function<ClientModel, ClientEntity> {
    @Override
    public ClientEntity apply(ClientModel clientModel) {
        return ClientEntity.builder()
                .id(!clientModel.getId().isEmpty() ? clientModel.getId() : null)
                .dni(clientModel.getDni())
                .name(clientModel.getName())
                .subname(clientModel.getSubname())
                .emailContact(clientModel.getEmailContact())
                .phoneContact(clientModel.phoneContact)
                .address(clientModel.getAddress()).build();
    }
}
