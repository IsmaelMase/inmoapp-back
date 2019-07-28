package com.inmoapp.realtormanager.controller;

import com.inmoapp.realtormanager.model.RealtorModel;
import com.inmoapp.realtormanager.service.RealtorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/realtors")
@CrossOrigin("*")
@Api(tags = "realtors-controller")
public class RealtorController {

    private RealtorService realtorService;

    public RealtorController(RealtorService realtorService) {
        this.realtorService = realtorService;
    }

    @GetMapping(value = "findById/{id}")
    @ApiOperation(value = "Find realtor by id")
    public RealtorModel getRealtorById(@PathVariable("id") String id) {
        return realtorService.findRealtorById(id);
    }

    @GetMapping(value = "findByRealEstate/{realEstateId}")
    @ApiOperation(value = "Find realtors by real estate ID")
    public Set<RealtorModel> getRealtorsEstateId(@PathVariable("id") String realEstateId) {
        return realtorService.findRealtorsByRealEstateId(realEstateId);
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "Find all realtors")
    public Set<RealtorModel> getAllRealtors() {
        return realtorService.findAllRealtors();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "Save realtor")
    public ResponseEntity saveRealtor(@Valid @RequestBody RealtorModel realtor) {
        return new ResponseEntity(realtorService.addRealtor(realtor), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "Delete realtor")
    public ResponseEntity deleteRealtor(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }

}
