package com.kaveen.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
}
