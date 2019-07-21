package com.users.User.component.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.users.User.component.entity.UserEntity;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<UserEntity, String> {

	List<UserEntity> findUserByRealEstateId(String realEstateId);

}
