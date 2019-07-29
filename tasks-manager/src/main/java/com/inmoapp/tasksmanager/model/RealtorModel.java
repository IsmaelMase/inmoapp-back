package com.inmoapp.tasksmanager.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

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