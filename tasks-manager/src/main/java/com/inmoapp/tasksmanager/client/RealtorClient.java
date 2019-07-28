package com.inmoapp.tasksmanager.client;

import com.inmoapp.tasksmanager.model.RealtorModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("realtor")
public interface RealtorClient {

    @GetMapping("/realtor/{id}")
    RealtorModel getRealtorById(@PathVariable("id") String id);
}
