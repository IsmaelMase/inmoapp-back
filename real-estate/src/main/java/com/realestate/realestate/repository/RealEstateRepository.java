package com.realestate.realestate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.realestate.realestate.entity.RealEstateEntity;

@Repository("realEstateRepository")
public interface RealEstateRepository extends MongoRepository<RealEstateEntity, String> {

}
