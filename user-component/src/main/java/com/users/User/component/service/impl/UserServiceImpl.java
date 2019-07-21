package com.users.User.component.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.users.User.component.converter.UserConverter;
import com.users.User.component.entity.UserEntity;
import com.users.User.component.model.UserModel;
import com.users.User.component.repository.UserRepository;
import com.users.User.component.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;

	public List<UserModel> findAll() {

		List<UserModel> userList = new ArrayList<UserModel>();

		for (UserEntity userEntity : userRepository.findAll()) {
			userList.add(userConverter.convertEntity2Model(userEntity));
		}

		return userList;
	}

	public UserModel findById(String id) {

		Optional<UserEntity> user = userRepository.findById(id);
		if (user.isPresent()) {
			return userConverter.convertEntity2Model(user.get());
		} else {
			return null;
		}
	}

	public List<UserModel> findByRealEstateId(String realEstateId) {
		List<UserModel> userList = new ArrayList<UserModel>();

		for (UserEntity userEntity : userRepository.findUserByRealEstateId(realEstateId)) {
			userList.add(userConverter.convertEntity2Model(userEntity));
		}

		return userList;
	}

	public ResponseEntity<UserModel> addUser(UserModel userModel) {
		try {
			UserEntity user = userRepository.save(userConverter.convertModel2Entity(userModel));

			return new ResponseEntity<UserModel>(userConverter.convertEntity2Model(user), HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<UserModel>(HttpStatus.BAD_REQUEST);

		}
	}

	public ResponseEntity<String> removeUser(String id) {
		try {

			userRepository.deleteById(id);

			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

}
