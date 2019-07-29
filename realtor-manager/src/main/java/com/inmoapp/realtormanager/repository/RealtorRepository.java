package com.inmoapp.realtormanager.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inmoapp.realtormanager.entity.RealtorEntity;

@Repository
public interface RealtorRepository extends MongoRepository<RealtorEntity, String> {

	Set<RealtorEntity> findRealtorByRealEstateId(String realEstateId);

	Optional<RealtorEntity> findRealtorByDni(String dni);

	Optional<RealtorEntity> findRealtorByEmailContact(String dni);

}
