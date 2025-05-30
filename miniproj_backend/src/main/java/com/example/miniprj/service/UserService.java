package com.example.miniprj.service;

import com.example.miniprj.dto.UserRequestDto;
import com.example.miniprj.dto.UserResponseDto;

import java.util.List;


public interface UserService {
    UserResponseDto createUser(UserRequestDto dto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUser(Long userId);
    void deleteUser(Long userId);
}
