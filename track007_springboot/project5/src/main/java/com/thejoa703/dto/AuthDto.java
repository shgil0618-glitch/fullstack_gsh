package com.thejoa703.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
    private int authId;
    private int appUserId; // FK
    private String email;  // 기존 로직 유지용
    private String auth;   // ROLE_USER, ROLE_ADMIN 등
    
    public AuthDto(String email, String auth, int appUserId) {
        this.email = email;
        this.auth = auth;
        this.appUserId = appUserId;
    }
}