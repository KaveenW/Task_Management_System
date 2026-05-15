package com.kaveen.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRequestDto {
    private String username;
    private String email;
    private String password;
}
