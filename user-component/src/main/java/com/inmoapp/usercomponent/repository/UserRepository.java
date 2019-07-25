package com.inmoapp.usercomponent.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inmoapp.usercomponent.entity.UserEntity;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<UserEntity, String> {

	List<UserEntity> findUserByRealEstateId(String realEstateId);

}
