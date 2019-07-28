package com.inmoapp.realtormanager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inmoapp.realtormanager.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

	List<UserEntity> findUserByRealEstateId(String realEstateId);

}
