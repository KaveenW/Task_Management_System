package com.kaveen.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaveen.taskmanager.dto.UserRequestDto;
import com.kaveen.taskmanager.dto.UserResponseDto;
import com.kaveen.taskmanager.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto dto){
        UserResponseDto response = userService.createUser(dto);
        return ResponseEntity.ok(response);
    }


}
