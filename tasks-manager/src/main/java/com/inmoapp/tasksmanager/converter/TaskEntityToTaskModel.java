package com.inmoapp.tasksmanager.converter;

import com.inmoapp.tasksmanager.entity.TaskEntity;
import com.inmoapp.tasksmanager.model.TaskModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TaskEntityToTaskModel implements Function<TaskEntity, TaskModel> {
    @Override
    public TaskModel apply(TaskEntity taskEntity) {
        return TaskModel.builder()
                .id(taskEntity.getId())
                .description(taskEntity.getDescription())
                .codref(taskEntity.getCodref())
                .state(taskEntity.getState())
                .realtorId(taskEntity.getRealtorId())
                .build();
    }
}
