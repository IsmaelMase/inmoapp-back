package com.inmoapp.usercomponent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmoapp.usercomponent.model.UserModel;
import com.inmoapp.usercomponent.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@Api(tags = "users-controller")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@GetMapping(value = "/user/{id}")
	public UserModel getUserById(@PathVariable("id") String id) {
		return userService.findById(id);
	}

	@GetMapping(value = "/user/{realEstateId}")
	public List<UserModel> getUsersEstateId(@PathVariable("id") String realEstateId) {
		return userService.findByRealEstateId(realEstateId);
	}

	@GetMapping(value = "/user/all")
	public List<UserModel> getAllUsers() {
		return userService.findAll();
	}

	@PostMapping(value = "/user/save")
	public ResponseEntity<UserModel> saveUser(@Valid @RequestBody UserModel user) {
		return userService.addUser(user);
	}

	@DeleteMapping(value = "/user/{id}/delete")
	public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
		return userService.removeUser(id);
	}

}
