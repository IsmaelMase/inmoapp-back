package com.inmoapp.tasks.converter;

import com.inmoapp.tasks.client.PropertyClient;
import com.inmoapp.tasks.entity.TaskEntity;
import com.inmoapp.tasks.model.TaskModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TaskEntityToTaskModel implements Function<TaskEntity, TaskModel> {

    @Override
    public TaskModel apply(TaskEntity taskEntity) {
        return TaskModel.builder()
                .id(taskEntity.getId())
                .propertyId(taskEntity.getPropertyId())
                .state(taskEntity.getState())
                .realtorId(taskEntity.getRealtorId())
                .comments(taskEntity.getComments())
                .build();
    }
}
