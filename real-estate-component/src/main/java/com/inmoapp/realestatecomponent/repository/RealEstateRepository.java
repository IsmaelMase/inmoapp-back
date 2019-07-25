package com.inmoapp.realestatecomponent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inmoapp.realestatecomponent.entity.RealEstateEntity;

@Repository("realEstateRepository")
public interface RealEstateRepository extends MongoRepository<RealEstateEntity, String> {

}
