package com.inmoapp.realtormanager.service.impl;

import com.inmoapp.realtormanager.client.RealEstateClient;
import com.inmoapp.realtormanager.converter.UserEntityToUserModel;
import com.inmoapp.realtormanager.converter.UserModelToUserEntity;
import com.inmoapp.realtormanager.entity.UserEntity;
import com.inmoapp.realtormanager.model.UserModel;
import com.inmoapp.realtormanager.repository.UserRepository;
import com.inmoapp.realtormanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserEntityToUserModel userEntityToUserModel;

    private final UserModelToUserEntity userModelToUserEntity;

    private final RealEstateClient realEstateClient;

    public UserServiceImpl(UserRepository userRepository, UserEntityToUserModel userEntityToUserModel, UserModelToUserEntity userModelToUserEntity,
                           RealEstateClient realEstateClient) {
        this.userRepository = userRepository;
        this.userEntityToUserModel = userEntityToUserModel;
        this.userModelToUserEntity = userModelToUserEntity
        this.realEstateClient = realEstateClient;
    }

    public Set<UserModel> findAllUsers() {

        return userRepository.findAll().stream().map(userEntityToUserModel).collect(Collectors.toSet());
    }

    public UserModel findUserById(String id) {

        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userConverter.convertEntity2Model(user.get());
        } else {
            return null;
        }
    }

    public List<UserModel> findUsersByRealEstateId(String realEstateId) {
        List<UserModel> userList = new ArrayList<UserModel>();

        for (UserEntity userEntity : userRepository.findUserByRealEstateId(realEstateId)) {
            userList.add(userConverter.convertEntity2Model(userEntity));
        }

        return userList;
    }

    public ResponseEntity<UserModel> addUser(UserModel userModel) {
        try {
            if (realEstateClient.getRealEstateById(userModel.realEstateId) != null) {
                UserEntity user = userRepository.save(userConverter.convertModel2Entity(userModel));

                return new ResponseEntity<UserModel>(userConverter.convertEntity2Model(user), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
            }

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
