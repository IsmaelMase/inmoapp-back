package com.inmoapp.tasks.service;

import com.inmoapp.tasks.model.TaskModel;

import java.util.Set;


public interface TaskService {

    Set<TaskModel> findAllTasks();

    TaskModel findTaskById(String id);

    Set<TaskModel> findTasksByRealtorId(String realtorId);

    Set<TaskModel> findTasksByState(String state);

    TaskModel addTask(TaskModel taskModel);

    void removeTask(String id);
}
