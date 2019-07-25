package com.inmoapp.realestatecomponent.converter;

import org.springframework.stereotype.Component;

import com.inmoapp.realestatecomponent.entity.RealEstateEntity;
import com.inmoapp.realestatecomponent.model.RealEstateModel;

@Component("realEstateConverter")
public class RealEstateConverter {

	public RealEstateModel convertEntity2Model(RealEstateEntity realEstateEntity) {

		RealEstateModel realEstateModel = new RealEstateModel();
		realEstateModel.id = !realEstateEntity.id.isEmpty() ? realEstateEntity.id : null;
		realEstateModel.name = realEstateEntity.name;
		realEstateModel.emailContact = realEstateEntity.emailContact;
		realEstateModel.phoneContacte = realEstateEntity.phoneContacte;
		realEstateModel.address = realEstateEntity.address;

		return realEstateModel;
	}

	public RealEstateEntity convertModel2Entity(RealEstateModel realEstateModel) {

		RealEstateEntity realEstateEntity = new RealEstateEntity();
		realEstateEntity.id = !realEstateModel.id.isEmpty() ? realEstateModel.id : null;
		realEstateEntity.name = realEstateModel.name;
		realEstateEntity.emailContact = realEstateModel.emailContact;
		realEstateEntity.phoneContacte = realEstateModel.phoneContacte;
		realEstateEntity.address = realEstateModel.address;

		return realEstateEntity;
	}

}
