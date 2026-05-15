package com.kaveen.taskmanager.mapper;

import org.springframework.stereotype.Component;

import com.kaveen.taskmanager.dto.UserRequestDto;
import com.kaveen.taskmanager.dto.UserResponseDto;
import com.kaveen.taskmanager.entity.UserEntity;

@Component
public class UserMapper {

    // 1. DTO -> Entity
    public UserEntity toEntity(UserRequestDto dto){
        if(dto == null) return null;
        UserEntity user = new UserEntity();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    // 2. Entity -> DTO
    public UserResponseDto toResponseDto(UserEntity user){
        if(user == null) return null;

        return new UserResponseDto(
            user.getId(), 
            user.getUsername(),
            user.getEmail()
        );
    }
}
