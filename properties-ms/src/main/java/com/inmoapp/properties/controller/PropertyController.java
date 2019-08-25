package com.inmoapp.properties.controller;

import com.inmoapp.properties.model.PropertyModel;
import com.inmoapp.properties.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/properties")
@CrossOrigin("*")
@Api(tags = "properties-controller")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping(value = "/findById/{id}")
    @ApiOperation(value = "Find property by id")
    public PropertyModel getPropertyById(@PathVariable("id") String id) {
        return propertyService.findPropertyById(id);
    }

    @GetMapping(value = "findByCodRef/{codRef}")
    @ApiOperation(value = "Find property by CodRef")
    public PropertyModel getPropertyByCorRef(@PathVariable("id") String codRef) {
        return propertyService.findPropertyByCodRef(codRef);
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "Find all property")
    public Set<PropertyModel> getAllProperties() {
        return propertyService.findAllProperties();
    }

    @PostMapping(value = "/save/{realtorId}")
    @ApiOperation(value = "Save property")
    public ResponseEntity saveProperty(@PathVariable("realtorId") String realtorId, @Valid @RequestBody PropertyModel property) {
        return new ResponseEntity(propertyService.addProperty(property, realtorId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "Delete property")
    public ResponseEntity deleteProperty(@PathVariable("id") String id) {
        propertyService.removeProperty(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
