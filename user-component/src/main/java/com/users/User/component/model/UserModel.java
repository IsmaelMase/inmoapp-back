package com.users.User.component.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

	public String id;
	public String dni;
	public String name;
	public String subname1;
	public String subname2;
	public String emailContact;
	public String phoneContacte;
	public String role;
	public String realEstateId;
}