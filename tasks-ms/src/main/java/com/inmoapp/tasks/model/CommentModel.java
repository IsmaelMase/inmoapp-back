package com.inmoapp.tasks.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentModel {
    public String realtorId;
    public String comment;
}
