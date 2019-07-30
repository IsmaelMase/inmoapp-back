package com.inmoapp.tasks.client;

import com.inmoapp.tasks.model.RealtorModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("realtor")
public interface RealtorClient {

    @GetMapping("/realtor/{id}")
    RealtorModel getRealtorById(@PathVariable("id") String id);
}
