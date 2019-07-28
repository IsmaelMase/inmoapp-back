package com.inmoapp.realestatemanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inmoapp.realestatemanager.entity.RealEstateEntity;

import java.util.Optional;

@Repository
public interface RealEstateRepository extends MongoRepository<RealEstateEntity, String> {
    Optional<RealEstateEntity> findRealEstateByCif(String cif);
}
