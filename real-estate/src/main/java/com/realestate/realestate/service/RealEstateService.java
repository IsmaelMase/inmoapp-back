package com.realestate.realestate.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.realestate.realestate.model.RealEstateModel;

public interface RealEstateService {

	public RealEstateModel findById(String id);

	public List<RealEstateModel> findAll();

	public ResponseEntity<RealEstateModel> addRealEstate(RealEstateModel realEstate);

	public ResponseEntity<String> removeRealEstate(String id);
}
