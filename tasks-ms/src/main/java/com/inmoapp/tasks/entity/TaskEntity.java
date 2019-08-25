package com.inmoapp.tasks.entity;

import com.inmoapp.tasks.model.CommentModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotEmpty;
import java.util.List;

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
	public String propertyId;
	@NotEmpty
	public String state;
	@NotEmpty
	public String realtorId;
	public List<CommentModel> comments;

}
