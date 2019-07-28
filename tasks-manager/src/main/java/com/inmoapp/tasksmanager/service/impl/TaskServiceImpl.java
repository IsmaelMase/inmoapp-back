package com.inmoapp.tasksmanager.service.impl;

import com.inmoapp.tasksmanager.client.RealtorClient;
import com.inmoapp.tasksmanager.converter.TaskEntityToTaskModel;
import com.inmoapp.tasksmanager.converter.TaskModelToTaskEntity;
import com.inmoapp.tasksmanager.entity.TaskEntity;
import com.inmoapp.tasksmanager.model.TaskModel;
import com.inmoapp.tasksmanager.model.exception.RealtorNotFound;
import com.inmoapp.tasksmanager.model.exception.TaskNotFound;
import com.inmoapp.tasksmanager.repository.TaskRepository;
import com.inmoapp.tasksmanager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskEntityToTaskModel taskEntityToTaskModel;

    private final TaskModelToTaskEntity taskModelToTaskEntity;

    private final RealtorClient realtorClient;


    public TaskServiceImpl(RealtorClient realtorClient, TaskRepository taskRepository, TaskEntityToTaskModel taskEntityToTaskModel, TaskModelToTaskEntity taskModelToTaskEntity) {
        this.taskRepository = taskRepository;
        this.taskEntityToTaskModel = taskEntityToTaskModel;
        this.taskModelToTaskEntity = taskModelToTaskEntity;
        this.realtorClient = realtorClient;
    }

    public Set<TaskModel> findAllTasks() {
        return taskRepository.findAll().stream().map(taskEntityToTaskModel).collect(Collectors.toSet());
    }

    public TaskModel findTaskById(String id) {
        return taskRepository.findById(id).map(taskEntityToTaskModel).orElseThrow(() -> new TaskNotFound(id));
    }

    public Set<TaskModel> findTasksByRealtorId(String realtorId) {
        return taskRepository.findTaskByRealtorId(realtorId).stream().map(taskEntityToTaskModel).collect(Collectors.toSet());
    }

    public Set<TaskModel> findTasksByState(String state) {
        return taskRepository.findTaskByState(state).stream().map(taskEntityToTaskModel).collect(Collectors.toSet());
    }

    public TaskModel addTask(TaskModel taskModel) {
        Optional.ofNullable(realtorClient.getRealtorById(taskModel.getRealtorId()))
                .orElseThrow(() -> new RealtorNotFound(taskModel.getRealtorId()));
        TaskEntity taskEntity = taskRepository.save(taskModelToTaskEntity.apply(taskModel));

        return taskEntityToTaskModel.apply(taskEntity);
    }

    public void removeTask(String id) {
        taskRepository.deleteById(id);
    }

}
