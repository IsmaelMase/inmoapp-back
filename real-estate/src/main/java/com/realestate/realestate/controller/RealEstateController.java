package com.realestate.realestate.controller;

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

import com.realestate.realestate.model.RealEstateModel;
import com.realestate.realestate.service.RealEstateService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/realEstate")
@CrossOrigin("*")
@Api(tags = "Real Estate Api")
public class RealEstateController {
	@Autowired
	@Qualifier("realEstateService")
	private RealEstateService realEstateService;

	@GetMapping(value = "/realEstate/{id}")
	public RealEstateModel getRealEstateById(@PathVariable("id") String id) {
		return realEstateService.findById(id);
	}

	@GetMapping(value = "/realEstate/all")
	public List<RealEstateModel> getAllRealEstate() {
		return realEstateService.findAll();
	}

	@PostMapping(value = "/realEstate/save")
	public ResponseEntity<RealEstateModel> saveRealEstate(@Valid @RequestBody RealEstateModel realEstate) {
		return realEstateService.addRealEstate(realEstate);
	}

	@DeleteMapping(value = "/realEstate/{id}/delete")
	public ResponseEntity<String> deleteRealEstate(@PathVariable("id") String id) {
		return realEstateService.removeRealEstate(id);
	}
}
