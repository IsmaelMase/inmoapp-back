package com.inmoapp.tasks.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTaskModel {
    public String id;
    @NotEmpty
    public PropertyModel propertyModel;
    @NotEmpty
    public String state;
    @NotEmpty
    public String realtorId;
    public List<CommentModel> comments;
}
