package com.inmoapp.tasksmanager.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inmoapp.tasksmanager.entity.TaskEntity;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity, String>{
	
	List<TaskEntity> findTaskByRealtorId(String realtorId);
	
	List<TaskEntity> findTaskByState(String state);

}
