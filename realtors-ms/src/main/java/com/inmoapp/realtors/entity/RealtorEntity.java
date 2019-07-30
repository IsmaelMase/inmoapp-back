package com.inmoapp.realtors.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "realtors")
@Getter
@Setter
@Builder
@ApiModel(value = "Realtor", description = "Model of realtors")
public class RealtorEntity {

	@Id
	public String id;
	public String nickname;
	public String name;
	public String subname;
	public String emailContact;
	public String phoneContact;
	public String role;
	public String realEstateId;
	public String password;
}
