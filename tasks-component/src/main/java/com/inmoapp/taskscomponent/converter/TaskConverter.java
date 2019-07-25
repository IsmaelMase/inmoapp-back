package com.inmoapp.taskscomponent.converter;

import org.springframework.stereotype.Component;

import com.inmoapp.taskscomponent.entity.TaskEntity;
import com.inmoapp.taskscomponent.model.TaskModel;

@Component("taskConverter")
public class TaskConverter {

	public TaskModel convertEntity2Model(TaskEntity taskEntity) {
		TaskModel taskModel = new TaskModel();
		taskModel.id = !taskEntity.id.isEmpty() ? taskEntity.id : null;
		taskModel.description = taskEntity.description;
		taskModel.codref = taskEntity.codref;
		taskModel.state = taskEntity.state;
		taskModel.userId = taskEntity.userId;

		return taskModel;
	}

	public TaskEntity convertModel2Entity(TaskModel taskModel) {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.id = !taskModel.id.isEmpty() ? taskModel.id : null;
		taskEntity.description = taskModel.description;
		taskEntity.codref = taskModel.codref;
		taskEntity.state = taskModel.state;
		taskEntity.userId = taskModel.userId;

		return taskEntity;
	}

}
