package com.inmoapp.realtormanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealtorModel {

	public String id;
	@NotEmpty
	public String dni;
//	@NotEmpty
//	public String userNick;
	@NotEmpty
	public String name;
	@NotEmpty
	public String subname;
	@NotEmpty
	public String emailContact;
	@NotEmpty
	public String phoneContact;
	@NotEmpty
	public String role;
	@NotEmpty
	public String realEstateId;
}