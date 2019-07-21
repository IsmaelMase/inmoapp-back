package com.realestate.realestate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.realestate.realestate.converter.RealEstateConverter;
import com.realestate.realestate.entity.RealEstateEntity;
import com.realestate.realestate.model.RealEstateModel;
import com.realestate.realestate.repository.RealEstateRepository;
import com.realestate.realestate.service.RealEstateService;

@Service("realEstateService")
public class RealEstateServiceImpl implements RealEstateService {

	@Autowired
	@Qualifier("realEstateRepository")
	private RealEstateRepository realEstateRepository;

	@Autowired
	@Qualifier("realEstateConverter")
	private RealEstateConverter realEstateConverter;

	public RealEstateModel findById(String id) {
		Optional<RealEstateEntity> realEstate = realEstateRepository.findById(id);
		if (realEstate.isPresent()) {
			return realEstateConverter.convertEntity2Model(realEstate.get());
		} else {
			return null;
		}
	}

	public List<RealEstateModel> findAll() {
		List<RealEstateModel> realEstateList = new ArrayList<RealEstateModel>();

		for (RealEstateEntity realEstateEntity : realEstateRepository.findAll()) {
			realEstateList.add(realEstateConverter.convertEntity2Model(realEstateEntity));
		}

		return realEstateList;

	}

	public ResponseEntity<RealEstateModel> addRealEstate(RealEstateModel realEstateModel) {
		try {
			RealEstateEntity realEstate = realEstateRepository
					.save(realEstateConverter.convertModel2Entity(realEstateModel));

			return new ResponseEntity<RealEstateModel>(realEstateConverter.convertEntity2Model(realEstate),
					HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<RealEstateModel>(HttpStatus.BAD_REQUEST);

		}
	}

	public ResponseEntity<String> removeRealEstate(String id) {
		try {

			realEstateRepository.deleteById(id);

			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

}
