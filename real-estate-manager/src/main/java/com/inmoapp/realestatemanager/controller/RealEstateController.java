package com.inmoapp.realestatemanager.controller;

import com.inmoapp.realestatemanager.model.RealEstateModel;
import com.inmoapp.realestatemanager.service.RealEstateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/realEstate")
@CrossOrigin("*")
@Api(tags = "real-estate-manager")
public class RealEstateController {

    private final RealEstateService realEstateService;

    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find real estate by id")
    public RealEstateModel getRealEstateById(@PathVariable("id") String id) {
        return realEstateService.findRealEstateById(id);
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "Find all real estate")
    public Set<RealEstateModel> getAllRealEstate() {
        return realEstateService.findAllRealEstate();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "Save real estate")
    public ResponseEntity saveRealEstate(@Valid @RequestBody RealEstateModel realEstate) {
        return new ResponseEntity(realEstateService.addRealEstate(realEstate), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "Delete real estate by id")
    public ResponseEntity deleteRealEstate(@PathVariable("id") String id) {
        realEstateService.removeRealEstate(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
