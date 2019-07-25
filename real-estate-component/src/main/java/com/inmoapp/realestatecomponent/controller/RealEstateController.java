package com.inmoapp.realestatecomponent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmoapp.realestatecomponent.model.RealEstateModel;
import com.inmoapp.realestatecomponent.service.RealEstateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/realEstate")
@CrossOrigin("*")
@Api(tags = "real-estate-component")
public class RealEstateController {
	@Autowired
	@Qualifier("realEstateService")
	private RealEstateService realEstateService;

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Find real estate by id")
	public RealEstateModel getRealEstateById(@PathVariable("id") String id) {
		return realEstateService.findById(id);
	}

	@GetMapping(value = "/all")
	@ApiOperation(value = "Find all real estate")
	public List<RealEstateModel> getAllRealEstate() {
		return realEstateService.findAll();
	}

	@PostMapping(value = "/save")
	@ApiOperation(value = "Save real estate")
	public ResponseEntity<RealEstateModel> saveRealEstate(@Valid @RequestBody RealEstateModel realEstate) {
		return realEstateService.addRealEstate(realEstate);
	}

	@DeleteMapping(value = "/delete/{id}")
	@ApiOperation(value = "Delete real estate by id")
	public ResponseEntity<String> deleteRealEstate(@PathVariable("id") String id) {
		return realEstateService.removeRealEstate(id);
	}
}
