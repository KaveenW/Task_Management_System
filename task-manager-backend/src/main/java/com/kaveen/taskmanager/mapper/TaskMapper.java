package com.kaveen.taskmanager.mapper;

import org.springframework.stereotype.Component;

import com.kaveen.taskmanager.dto.TaskRequestDto;
import com.kaveen.taskmanager.dto.TaskResponseDto;
import com.kaveen.taskmanager.entity.TaskEntity;
import com.kaveen.taskmanager.entity.UserEntity;

@Component
public class TaskMapper {

    //1. DTO + User -> Entity(For Creating)
    public TaskEntity toEntity(TaskRequestDto dto, UserEntity user){
        if(dto == null) return null;
        TaskEntity task = new TaskEntity();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());

        task.setStatus(TaskEntity.Status.TODO);
        // This is the "Staple" - we link the actual User object to the Task
        task.setUser(user);
        return task;
    }

    // 2. Entity -> Response DTO (For Sending back to Frotend)
    public TaskResponseDto toResponseDto(TaskEntity task){
        if(task == null) return null;
        
        // We 'Flatten' the data. Instead of sending the whole User object,
        // we just send the ID and Username so the frontend can display it easily.
        return new TaskResponseDto(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getStatus() != null ? task.getStatus().name(): null,
            task.getDueDate(),
            task.getUser().getId(),
            task.getUser().getUsername()
        );
    }
}
