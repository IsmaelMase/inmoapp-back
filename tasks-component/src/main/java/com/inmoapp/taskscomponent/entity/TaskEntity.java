package com.inmoapp.taskscomponent.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Task", description = "Model of task")
public class TaskEntity {
	
	@Id
	public String id;
	public String description;
	public String codref;
	public String state;
	public String userId;

}
