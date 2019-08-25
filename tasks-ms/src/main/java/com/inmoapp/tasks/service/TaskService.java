package com.inmoapp.tasks.service;

import com.inmoapp.tasks.model.CommentModel;
import com.inmoapp.tasks.model.ResponseTaskModel;
import com.inmoapp.tasks.model.TaskModel;

import java.util.HashMap;
import java.util.Set;


public interface TaskService {

    Set<TaskModel> findAllTasks();

    HashMap<String, Set<ResponseTaskModel>> findAllTasksOrderByState();

    TaskModel findTaskById(String id);

    Set<TaskModel> findTasksByRealtorId(String realtorId);

    Set<TaskModel> findTasksByState(String state);

    TaskModel createInitTask(String realtorId, String propertyId);

    TaskModel addTask(TaskModel taskModel);

    void removeTask(String id);

    TaskModel addCommentToTask(String taskId, CommentModel commentModel);

    TaskModel changeState(String taskId, String state);

}
