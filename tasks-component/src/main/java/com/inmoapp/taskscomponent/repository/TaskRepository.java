package com.inmoapp.taskscomponent.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inmoapp.taskscomponent.entity.TaskEntity;

@Repository("taskRepository")
public interface TaskRepository extends MongoRepository<TaskEntity, String>{
	
	List<TaskEntity> findTaskByUserId(String userId);
	
	List<TaskEntity> findTaskByState(String state);

}
