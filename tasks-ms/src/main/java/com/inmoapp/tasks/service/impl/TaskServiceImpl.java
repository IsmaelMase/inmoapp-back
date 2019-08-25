package com.inmoapp.tasks.service.impl;

import com.inmoapp.tasks.client.RealtorClient;
import com.inmoapp.tasks.constants.TaskConstants;
import com.inmoapp.tasks.converter.TaskEntityToResponseTaskModel;
import com.inmoapp.tasks.converter.TaskEntityToTaskModel;
import com.inmoapp.tasks.converter.TaskModelToTaskEntity;
import com.inmoapp.tasks.entity.TaskEntity;
import com.inmoapp.tasks.model.CommentModel;
import com.inmoapp.tasks.model.ResponseTaskModel;
import com.inmoapp.tasks.model.TaskModel;
import com.inmoapp.tasks.model.exception.RealtorNotFound;
import com.inmoapp.tasks.model.exception.TaskNotFound;
import com.inmoapp.tasks.repository.TaskRepository;
import com.inmoapp.tasks.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskEntityToTaskModel taskEntityToTaskModel;

    private final TaskModelToTaskEntity taskModelToTaskEntity;

    private final TaskEntityToResponseTaskModel taskEntityToResponseTaskModel;

    private final RealtorClient realtorClient;

    private final TaskConstants taskConstants;


    public TaskServiceImpl(RealtorClient realtorClient, TaskRepository taskRepository, TaskEntityToTaskModel taskEntityToTaskModel, TaskModelToTaskEntity taskModelToTaskEntity, TaskConstants taskConstants, TaskEntityToResponseTaskModel taskEntityToResponseTaskModel, TaskConstants taskConstants1) {
        this.taskRepository = taskRepository;
        this.taskEntityToTaskModel = taskEntityToTaskModel;
        this.taskModelToTaskEntity = taskModelToTaskEntity;
        this.realtorClient = realtorClient;
        this.taskEntityToResponseTaskModel = taskEntityToResponseTaskModel;
        this.taskConstants = taskConstants1;
    }

    public Set<TaskModel> findAllTasks() {
        return taskRepository.findAll().stream().map(taskEntityToTaskModel).collect(Collectors.toSet());
    }

    public HashMap<String, Set<ResponseTaskModel>> findAllTasksOrderByState() {

        Set<ResponseTaskModel> interestingTasks = taskRepository.findTaskByState(taskConstants.INTERESTING).stream().map(taskEntityToResponseTaskModel).collect(Collectors.toSet());
        Set<ResponseTaskModel> inContactTasks = taskRepository.findTaskByState(taskConstants.PROPERTY_CONTACT).stream().map(taskEntityToResponseTaskModel).collect(Collectors.toSet());
        Set<ResponseTaskModel> blockedTasks = taskRepository.findTaskByState(taskConstants.PROPERTY_BLOCKED).stream().map(taskEntityToResponseTaskModel).collect(Collectors.toSet());
        Set<ResponseTaskModel> okTasks = taskRepository.findTaskByState(taskConstants.PROPERTY_OK).stream().map(taskEntityToResponseTaskModel).collect(Collectors.toSet());

        HashMap<String, Set<ResponseTaskModel>> allMapTasks = new HashMap<>();
        allMapTasks.put(taskConstants.INTERESTING, interestingTasks);
        allMapTasks.put(taskConstants.PROPERTY_CONTACT, inContactTasks);
        allMapTasks.put(taskConstants.PROPERTY_BLOCKED, blockedTasks);
        allMapTasks.put(taskConstants.PROPERTY_OK, okTasks);

        return allMapTasks;
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

    @Override
    public TaskModel createInitTask(String realtorId, String propertyId) {
        Optional.ofNullable(realtorClient.getRealtorById(realtorId))
                .orElseThrow(() -> new RealtorNotFound(realtorId));
        TaskModel taskModel = new TaskModel("", propertyId, taskConstants.INTERESTING, realtorId, new ArrayList<>());
        TaskEntity taskEntity = taskRepository.save(taskModelToTaskEntity.apply(taskModel));

        return taskEntityToTaskModel.apply(taskEntity);
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

    @Override
    public TaskModel addCommentToTask(String taskId, CommentModel commentModel) {
        TaskModel taskModel = taskRepository.findById(taskId).map(taskEntityToTaskModel).orElseThrow(() -> new TaskNotFound(taskId));
        taskModel.getComments().add(commentModel);
        TaskEntity taskEntity = taskRepository.save(taskModelToTaskEntity.apply(taskModel));

        return taskEntityToTaskModel.apply(taskEntity);
    }

    @Override
    public TaskModel changeState(String taskId, String state) {
        TaskModel taskModel = taskRepository.findById(taskId).map(taskEntityToTaskModel).orElseThrow(() -> new TaskNotFound(taskId));
        taskModel.setState(state);
        TaskEntity taskEntity = taskRepository.save(taskModelToTaskEntity.apply(taskModel));

        return taskEntityToTaskModel.apply(taskEntity);
    }

}
