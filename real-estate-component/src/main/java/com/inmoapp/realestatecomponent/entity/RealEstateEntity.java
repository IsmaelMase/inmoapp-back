package com.inmoapp.realestatecomponent.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "real-estate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "RealEstate", description = "Model of real state")
public class RealEstateEntity {

	@Id
	public String id;
	public String name;
	public String emailContact;
	public String phoneContacte;
	public String address;
}
