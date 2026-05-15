package com.kaveen.taskmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaveen.taskmanager.dto.TaskRequestDto;
import com.kaveen.taskmanager.dto.TaskResponseDto;
import com.kaveen.taskmanager.service.TaskService;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto request) {
        TaskResponseDto response = taskService.createTask(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
}
