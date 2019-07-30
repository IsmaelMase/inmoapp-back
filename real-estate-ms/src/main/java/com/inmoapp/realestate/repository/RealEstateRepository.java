package com.inmoapp.realestate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inmoapp.realestate.entity.RealEstateEntity;

@Repository
public interface RealEstateRepository extends MongoRepository<RealEstateEntity, String> {
}
