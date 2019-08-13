package com.inmboapp.clients.repository;

import com.inmboapp.clients.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<ClientEntity,String> {
    Optional<ClientEntity> findClientByDni(String dni);
}
