package com.inmoapp.realtormanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

	public String id;
	public String dni;
	public String name;
	public String subname1;
	public String subname2;
	public String emailContact;
	public String phoneContact;
	public String role;
	public String realEstateId;
}