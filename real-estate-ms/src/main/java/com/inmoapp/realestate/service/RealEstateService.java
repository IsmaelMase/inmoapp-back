package com.inmoapp.realestate.service;

import java.util.Set;

import com.inmoapp.realestate.model.RealEstateModel;

public interface RealEstateService {

	public RealEstateModel findRealEstateById(String id);

	public Set<RealEstateModel> findAllRealEstate();

	public RealEstateModel addRealEstate(RealEstateModel realEstate);

	public RealEstateModel updateRealEstate(RealEstateModel realEstate);

	public void removeRealEstate(String id);
}
