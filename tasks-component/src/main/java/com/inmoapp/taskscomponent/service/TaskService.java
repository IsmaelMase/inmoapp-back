package com.inmoapp.taskscomponent.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.inmoapp.taskscomponent.model.TaskModel;


public interface TaskService {
	
	public List<TaskModel> findAll();

	public TaskModel findById(String id);

	public List<TaskModel> findByUserId(String userId);
	
	public List<TaskModel> findByState(String state);

	public ResponseEntity<TaskModel> addTask(TaskModel task);

	public ResponseEntity<String> removeTask(String id);
}
