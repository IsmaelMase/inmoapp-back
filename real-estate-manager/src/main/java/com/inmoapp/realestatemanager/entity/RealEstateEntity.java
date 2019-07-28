package com.inmoapp.realestatemanager.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotEmpty;

@Document(collection = "real-estate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "RealEstate", description = "Model of real state")
public class RealEstateEntity {

	@Id
	public String id;
	@NotEmpty
	private String cif;
	@NotEmpty
	public String name;
	@NotEmpty
	public String emailContact;
	@NotEmpty
	public String phoneContacte;
	@NotEmpty
	public String address;
}
