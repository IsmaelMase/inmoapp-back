package com.inmoapp.tasksmanager.model.exception;

public class TaskNotFound extends RuntimeException {
    public TaskNotFound(String taskId) {
        super("The task with id "+taskId+" not exist");
    }
}

