package com.inmoapp.properties.repository;

import com.inmoapp.properties.entity.PropertyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyRepository extends MongoRepository<PropertyEntity, String> {

    public Optional<PropertyEntity> findPropertyByCodRef(String codRef);
}
