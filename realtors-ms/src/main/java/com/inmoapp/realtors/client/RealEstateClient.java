package com.inmoapp.realtors.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.inmoapp.realtors.model.RealEstateModel;

@FeignClient("real-estate")
public interface RealEstateClient {

	 @GetMapping("/realEstate/{id}")
	 public RealEstateModel getRealEstateById(@PathVariable("id") String id);
}
