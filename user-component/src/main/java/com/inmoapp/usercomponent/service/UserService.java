package com.inmoapp.usercomponent.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.inmoapp.usercomponent.model.UserModel;

public interface UserService {

	public List<UserModel> findAll();

	public UserModel findById(String id);

	public List<UserModel> findByRealEstateId(String realEstateId);

	public ResponseEntity<UserModel> addUser(UserModel user);

	public ResponseEntity<String> removeUser(String id);

}
