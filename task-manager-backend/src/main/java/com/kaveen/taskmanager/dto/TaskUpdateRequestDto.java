package com.kaveen.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskUpdateRequestDto {
    private String title;
    private String description;
    private String status;
}
