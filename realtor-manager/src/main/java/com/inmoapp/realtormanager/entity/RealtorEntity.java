package com.inmoapp.realtormanager.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
@Builder
@ApiModel(value = "User", description = "Model of users")
public class UserEntity {

	@Id
	public String id;
	public String dni;
	public String name;
	public String subname1;
	public String subname2;
	public String emailContact;
	public String phoneContact;
	public String role;
	public String realEstateId;
	public String password;
}
