package com.inmoapp.usercomponent.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inmoapp.usercomponent.converter.UserConverter;
import com.inmoapp.usercomponent.entity.UserEntity;
import com.inmoapp.usercomponent.model.UserModel;
import com.inmoapp.usercomponent.repository.UserRepository;
import com.inmoapp.usercomponent.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;

	// @Autowired
	// private RealEstateClient realEstateClient;

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
			// if (realEstateClient.getRealEstateById(userModel.realEstateId) != null) {
			UserEntity user = userRepository.save(userConverter.convertModel2Entity(userModel));

			return new ResponseEntity<UserModel>(userConverter.convertEntity2Model(user), HttpStatus.CREATED);
			// } else {
			// return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
			// }

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
