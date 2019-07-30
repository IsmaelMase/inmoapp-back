package com.inmoapp.tasks.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskModel {


	public String id;
	@NotEmpty
	public String description;
	@NotEmpty
	public String codref;
	@NotEmpty
	public String state;
	@NotEmpty
	public String realtorId;

}