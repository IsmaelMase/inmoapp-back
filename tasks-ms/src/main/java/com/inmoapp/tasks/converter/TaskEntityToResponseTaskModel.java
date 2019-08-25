package com.inmoapp.tasks.converter;

import com.inmoapp.tasks.client.PropertyClient;
import com.inmoapp.tasks.entity.TaskEntity;
import com.inmoapp.tasks.model.ResponseTaskModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TaskEntityToResponseTaskModel implements Function<TaskEntity, ResponseTaskModel> {

    public final PropertyClient propertyClient;

    public TaskEntityToResponseTaskModel(PropertyClient propertyClient) {
        this.propertyClient = propertyClient;
    }

    @Override
    public ResponseTaskModel apply(TaskEntity taskEntity) {
        return ResponseTaskModel.builder()
                .id(taskEntity.getId())
                .propertyModel(propertyClient.getPropertyById(taskEntity.getPropertyId()))
                .state(taskEntity.getState())
                .realtorId(taskEntity.getRealtorId())
                .comments(taskEntity.getComments())
                .build();
    }
}