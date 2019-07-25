package com.inmoapp.taskscomponent.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inmoapp.taskscomponent.converter.TaskConverter;
import com.inmoapp.taskscomponent.entity.TaskEntity;
import com.inmoapp.taskscomponent.model.TaskModel;
import com.inmoapp.taskscomponent.repository.TaskRepository;
import com.inmoapp.taskscomponent.service.TaskService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Autowired
	@Qualifier("taskRepository")
	private TaskRepository taskRepository;

	@Autowired
	@Qualifier("taskConverter")
	private TaskConverter taskConverter;

	public List<TaskModel> findAll() {
		List<TaskModel> taskList = new ArrayList<TaskModel>();

		for (TaskEntity taskEntity : taskRepository.findAll()) {
			taskList.add(taskConverter.convertEntity2Model(taskEntity));
		}

		return taskList;
	}

	public TaskModel findById(String id) {
		Optional<TaskEntity> user = taskRepository.findById(id);
		if (user.isPresent()) {
			return taskConverter.convertEntity2Model(user.get());
		} else {
			return null;
		}
	}

	public List<TaskModel> findByUserId(String userId) {
		List<TaskModel> taskList = new ArrayList<TaskModel>();

		for (TaskEntity taskEntity : taskRepository.findTaskByUserId(userId)) {
			taskList.add(taskConverter.convertEntity2Model(taskEntity));
		}

		return taskList;
	}
	
	public List<TaskModel> findByState(String state) {
		List<TaskModel> taskList = new ArrayList<TaskModel>();

		for (TaskEntity taskEntity : taskRepository.findTaskByState(state)) {
			taskList.add(taskConverter.convertEntity2Model(taskEntity));
		}

		return taskList;
	}

	public ResponseEntity<TaskModel> addTask(TaskModel task) {
		try {
			TaskEntity taskEntity = taskRepository.save(taskConverter.convertModel2Entity(task));

			return new ResponseEntity<TaskModel>(taskConverter.convertEntity2Model(taskEntity), HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<TaskModel>(HttpStatus.BAD_REQUEST);

		}
	}

	public ResponseEntity<String> removeTask(String id) {
		try {

			taskRepository.deleteById(id);

			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

}
