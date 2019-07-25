package com.inmoapp.usercomponent.converter;

import org.springframework.stereotype.Component;

import com.inmoapp.usercomponent.entity.UserEntity;
import com.inmoapp.usercomponent.model.UserModel;

@Component("userConverter")
public class UserConverter {

	public UserModel convertEntity2Model(UserEntity userEntity) {

		UserModel userModel = new UserModel();
		userModel.id = !userEntity.id.isEmpty() ? userEntity.id : null;
		userModel.dni = userEntity.dni;
		userModel.subname1 = userEntity.subname1;
		userModel.subname2 = userEntity.subname2;
		userModel.name = userEntity.name;
		userModel.emailContact = userEntity.emailContact;
		userModel.phoneContacte = userEntity.phoneContacte;
		userModel.role = userEntity.role;
		userModel.realEstateId = userEntity.realEstateId;

		return userModel;
	}

	public UserEntity convertModel2Entity(UserModel userModel) {

		UserEntity userEntity = new UserEntity();
		userEntity.id = !userModel.id.isEmpty() ? userModel.id : null;
		userEntity.dni = userModel.dni;
		userEntity.subname1 = userModel.subname1;
		userEntity.subname2 = userModel.subname2;
		userEntity.name = userModel.name;
		userEntity.emailContact = userModel.emailContact;
		userEntity.phoneContacte = userModel.phoneContacte;
		userEntity.role = userModel.role;
		userEntity.realEstateId = userModel.realEstateId;

		return userEntity;
	}
}
