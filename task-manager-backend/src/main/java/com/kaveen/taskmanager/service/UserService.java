package com.kaveen.taskmanager.service;

import com.kaveen.taskmanager.dto.UserRequestDto;
import com.kaveen.taskmanager.dto.UserResponseDto;


public interface UserService {

    UserResponseDto createUser(UserRequestDto request);
}
