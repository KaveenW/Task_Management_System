package com.kaveen.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaveen.taskmanager.dto.TaskRequestDto;
import com.kaveen.taskmanager.dto.TaskResponseDto;
import com.kaveen.taskmanager.dto.TaskUpdateRequestDto;
import com.kaveen.taskmanager.entity.TaskEntity;
import com.kaveen.taskmanager.entity.TaskEntity.Status;
import com.kaveen.taskmanager.entity.UserEntity;
import com.kaveen.taskmanager.mapper.TaskMapper;
import com.kaveen.taskmanager.repository.TaskRepository;
import com.kaveen.taskmanager.repository.UserRepository;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
    }
    @Override
    public TaskResponseDto createTask(TaskRequestDto request) {
        // Fetch the user fro the DB using the ID in the resquest
        UserEntity user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));
        // Convert resquestDto to TaskEntity 
        TaskEntity taskEntity = taskMapper.toEntity(request, user);
        // Save TaskEntity to DB
        TaskEntity savedTaskEntity = taskRepository.save(taskEntity);
        // Convert back to send responseDto to the frontend
        return taskMapper.toResponseDto(savedTaskEntity);
    }

    @Override
    public List<TaskResponseDto> getAllTasks(Long userId) {
        List<TaskEntity> tasks = taskRepository.findAllTasksByUserId(userId);
         return tasks.stream().map(taskMapper::toResponseDto).toList();
    }

    @Override
    public void deleteTask(Long taskId) {
        if(!taskRepository.existsById(taskId)){
            throw new RuntimeException("Task not found!");
        }
        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskResponseDto updateTaskStatus(Long taskId, TaskUpdateRequestDto taskDto) {
        TaskEntity task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found") );

        if(taskDto.getTitle() != null){
            task.setTitle(taskDto.getTitle());
        }
        
        if(taskDto.getDescription() != null){
            task.setDescription(taskDto.getDescription());
        }

        if(taskDto.getStatus() != null){
            task.setStatus(Status.valueOf(taskDto.getStatus().toUpperCase()));
        }

        TaskEntity updatedEntity = taskRepository.save(task);
        return taskMapper.toResponseDto(updatedEntity);
    }



    
}
