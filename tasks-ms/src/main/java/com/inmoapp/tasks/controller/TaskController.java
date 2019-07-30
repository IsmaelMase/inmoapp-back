package com.inmoapp.tasks.controller;

import com.inmoapp.tasks.model.TaskModel;
import com.inmoapp.tasks.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
@Api(tags = "tasks-controller")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find task by id")
    public TaskModel getTaskById(@PathVariable("id") String id) {
        return taskService.findTaskById(id);
    }

    @GetMapping(value = "/{realtorId}")
    @ApiOperation(value = "Find task by user ID")
    public Set<TaskModel> getTasksByRealtorId(@PathVariable("id") String realtorId) {
        return taskService.findTasksByRealtorId(realtorId);
    }

    @GetMapping(value = "/{state}")
    @ApiOperation(value = "Find task by state")
    public Set<TaskModel> getTasksByState(@PathVariable("state") String state) {
        return taskService.findTasksByState(state);
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "Find all task")
    public Set<TaskModel> getAllTasks() {
        return taskService.findAllTasks();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "Save task")
    public ResponseEntity saveTask(@Valid @RequestBody TaskModel task) {
        return new ResponseEntity(taskService.addTask(task), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "Delete task")
    public ResponseEntity deleteTask(@PathVariable("id") String id) {
        taskService.removeTask(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
