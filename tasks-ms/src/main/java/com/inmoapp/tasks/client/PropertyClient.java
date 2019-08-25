package com.inmoapp.tasks.client;

import com.inmoapp.tasks.model.PropertyModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("properties")
public interface PropertyClient {

    @GetMapping("/properties/findById/{id}")
    PropertyModel getPropertyById(@PathVariable("id") String id);

}
