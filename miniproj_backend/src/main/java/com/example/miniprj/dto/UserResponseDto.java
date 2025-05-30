// UserResponseDto.java
package com.example.miniprj.dto;

import com.example.miniprj.entity.Users;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long userId;
    private String username;
    private String email;

    public UserResponseDto(Users user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
