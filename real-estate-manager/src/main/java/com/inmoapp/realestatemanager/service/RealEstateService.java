package com.inmoapp.realestatemanager.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.inmoapp.realestatemanager.model.RealEstateModel;

public interface RealEstateService {

	public RealEstateModel findRealEstateById(String id);

	public Set<RealEstateModel> findAllRealEstate();

	public RealEstateModel addRealEstate(RealEstateModel realEstate);

	public RealEstateModel updateRealEstate(RealEstateModel realEstate);

	public void removeRealEstate(String id);
}
