package com.kaveen.taskmanager.service;

import java.util.List;

import com.kaveen.taskmanager.dto.TaskRequestDto;
import com.kaveen.taskmanager.dto.TaskResponseDto;
import com.kaveen.taskmanager.dto.TaskUpdateRequestDto;

public interface TaskService {

    TaskResponseDto createTask(TaskRequestDto request);

    List<TaskResponseDto> getAllTasks(Long userId);

    TaskResponseDto updateTaskStatus(Long taskId, TaskUpdateRequestDto taskUpdateRequestDto);

    void deleteTask(Long taskId);
}
