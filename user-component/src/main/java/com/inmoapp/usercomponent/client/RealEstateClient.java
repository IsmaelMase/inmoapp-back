package com.inmoapp.usercomponent.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inmoapp.usercomponent.model.RealEstateModel;

@FeignClient("real-estate")
public interface RealEstateClient {

	 @GetMapping("/realEstate/{id}")
	 public RealEstateModel getRealEstateById(@PathVariable("id") String id);
}
