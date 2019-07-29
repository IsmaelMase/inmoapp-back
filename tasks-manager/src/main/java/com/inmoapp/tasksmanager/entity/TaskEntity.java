package com.inmoapp.tasksmanager.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotEmpty;

@Document(collection = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Task", description = "Model of task")
public class TaskEntity {
	
	@Id
	public String id;
	@NotEmpty
	public String description;
	@NotEmpty
	public String codref;
	@NotEmpty
	public String state;
	@NotEmpty
	public String realtorId;

}
