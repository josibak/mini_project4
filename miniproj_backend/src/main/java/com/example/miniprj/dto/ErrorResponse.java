package com.example.miniprj.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int code;        // HTTP 상태 코드
    private String status;   // "error" 등 상태 문자열
    private String message;  // 에러 메시지
}
