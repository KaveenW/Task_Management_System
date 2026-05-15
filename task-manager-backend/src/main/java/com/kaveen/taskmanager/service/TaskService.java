package com.kaveen.taskmanager.service;

import com.kaveen.taskmanager.dto.TaskRequestDto;
import com.kaveen.taskmanager.dto.TaskResponseDto;

public interface TaskService {

    TaskResponseDto createTask(TaskRequestDto request);

    // List<TaskResponseDto> getTaskByUserId(Long userId);

    // TaskResponseDto updateTaskStatus(Long taskId, String status);

    // void deleteTask(Long taskId);
}
