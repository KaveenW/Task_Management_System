package com.kaveen.taskmanager.service;

import org.springframework.stereotype.Service;

import com.kaveen.taskmanager.dto.UserRequestDto;
import com.kaveen.taskmanager.dto.UserResponseDto;
import com.kaveen.taskmanager.entity.UserEntity;
import com.kaveen.taskmanager.mapper.UserMapper;
import com.kaveen.taskmanager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto request) {
        UserEntity user = userMapper.toEntity(request);
        UserEntity savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }
    
}
