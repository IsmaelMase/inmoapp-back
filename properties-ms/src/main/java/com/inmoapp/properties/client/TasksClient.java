package com.inmoapp.properties.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("tasks")
public interface TasksClient {
    @PostMapping(value = "/tasks/saveInitTask/{realtorId}/{propertyId}")
    public ResponseEntity saveInitTask(@PathVariable("realtorId") String realtorId, @PathVariable("propertyId") String propertyId);
}
