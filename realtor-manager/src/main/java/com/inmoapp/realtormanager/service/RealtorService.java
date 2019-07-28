package com.inmoapp.realtormanager.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.inmoapp.realtormanager.model.UserModel;

public interface UserService {

	Set<UserModel> findAllUsers();

	UserModel findUserById(String id);

	List<UserModel> findUsersByRealEstateId(String realEstateId);

	ResponseEntity<UserModel> addUser(UserModel user);

	ResponseEntity<String> removeUser(String id);

}
