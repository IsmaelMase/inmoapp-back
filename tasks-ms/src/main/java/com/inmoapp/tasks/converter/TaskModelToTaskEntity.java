package com.inmoapp.tasks.converter;

import com.inmoapp.tasks.entity.TaskEntity;
import com.inmoapp.tasks.model.TaskModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TaskModelToTaskEntity implements Function<TaskModel, TaskEntity> {
    @Override
    public TaskEntity apply(TaskModel taskModel) {
        return TaskEntity.builder()
                .id(!taskModel.getId().isEmpty() ? taskModel.getId() : null)
                .description(taskModel.getDescription())
                .propertyId(taskModel.getPropertyId())
                .state(taskModel.getState())
                .realtorId(taskModel.getRealtorId())
                .build();
    }
}
