package com.users.User.component.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User", description = "Model of real state")
public class UserEntity {

	@Id
	public String id;
	public String dni;
	public String name;
	public String subname1;
	public String subname2;
	public String emailContact;
	public String phoneContacte;
	public String role;
	public String realEstateId;
	public String password;
}
