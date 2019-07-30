package com.inmoapp.realtors.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inmoapp.realtors.entity.RealtorEntity;

@Repository
public interface RealtorRepository extends MongoRepository<RealtorEntity, String> {

	Set<RealtorEntity> findRealtorByRealEstateId(String realEstateId);

	Optional<RealtorEntity> findRealtorByNickname(String nickname);

	Optional<RealtorEntity> findRealtorByEmailContact(String email);

}
