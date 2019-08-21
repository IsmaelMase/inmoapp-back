package com.inmoapp.properties.client;

import com.inmoapp.properties.model.TaskModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient("tasks")
public interface TasksClient {
    @PostMapping(value = "/tasks/save")
    public ResponseEntity saveTask(@Valid @RequestBody TaskModel taskModel);
}
