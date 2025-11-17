package com.thejoa703.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int appUserId;          // PK
    private String email;           // 이메일
    private String password;        // 비밀번호
    private Integer mbtiTypeId;     // MBTI 타입
    private LocalDateTime createdAt; // 생성일
}
