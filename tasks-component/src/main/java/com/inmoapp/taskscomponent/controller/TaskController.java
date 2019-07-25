package com.inmoapp.taskscomponent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmoapp.taskscomponent.model.TaskModel;
import com.inmoapp.taskscomponent.service.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
@Api(tags = "tasks-controller")
public class TaskController {

	@Autowired
	@Qualifier("taskService")
	private TaskService taskService;

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Find task by id")
	public TaskModel getTaskById(@PathVariable("id") String id) {
		return taskService.findById(id);
	}

	@GetMapping(value = "/{userId}")
	@ApiOperation(value = "Find task by user ID")
	public List<TaskModel> getTasksByUserId(@PathVariable("id") String userId) {
		return taskService.findByUserId(userId);
	}
	
	@GetMapping(value = "/{state}")
	@ApiOperation(value = "Find task by state")
	public List<TaskModel> getTasksByState(@PathVariable("state") String state) {
		return taskService.findByState(state);
	}

	@GetMapping(value = "/all")
	@ApiOperation(value = "Find all task")
	public List<TaskModel> getAllTasks() {
		return taskService.findAll();
	}

	@PostMapping(value = "/save")
	@ApiOperation(value = "Save task")
	public ResponseEntity<TaskModel> saveTask(@Valid @RequestBody TaskModel task) {
		return taskService.addTask(task);
	}

	@DeleteMapping(value = "/delete/{id}")
	@ApiOperation(value = "Delete task")
	public ResponseEntity<String> deleteTask(@PathVariable("id") String id) {
		return taskService.removeTask(id);
	}
}
