package com.inmoapp.tasksmanager.converter;

import com.inmoapp.tasksmanager.entity.TaskEntity;
import com.inmoapp.tasksmanager.model.TaskModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TaskModelToTaskEntity implements Function<TaskModel, TaskEntity> {
    @Override
    public TaskEntity apply(TaskModel taskModel) {
        return TaskEntity.builder()
                .id(!taskModel.getId().isEmpty() ? taskModel.getId() : null)
                .description(taskModel.getDescription())
                .codref(taskModel.getCodref())
                .state(taskModel.getState())
                .realtorId(taskModel.getRealtorId())
                .build();
    }
}
