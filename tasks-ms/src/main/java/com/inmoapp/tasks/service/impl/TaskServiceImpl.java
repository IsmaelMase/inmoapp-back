package com.inmoapp.tasks.service.impl;

import com.inmoapp.tasks.client.RealtorClient;
import com.inmoapp.tasks.converter.TaskEntityToTaskModel;
import com.inmoapp.tasks.converter.TaskModelToTaskEntity;
import com.inmoapp.tasks.entity.TaskEntity;
import com.inmoapp.tasks.model.TaskModel;
import com.inmoapp.tasks.model.exception.RealtorNotFound;
import com.inmoapp.tasks.model.exception.TaskNotFound;
import com.inmoapp.tasks.repository.TaskRepository;
import com.inmoapp.tasks.service.TaskService;
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
