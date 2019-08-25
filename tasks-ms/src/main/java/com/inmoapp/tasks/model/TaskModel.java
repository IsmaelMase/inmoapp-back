package com.inmoapp.tasks.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskModel {

	public String id;
	@NotEmpty
	public String propertyId;
	@NotEmpty
	public String state;
	@NotEmpty
	public String realtorId;
	public List<CommentModel> comments;

}