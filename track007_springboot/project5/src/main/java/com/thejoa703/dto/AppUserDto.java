package com.thejoa703.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer appUserId; 
    private String email;    
    private String password;    
    private String nickname;
    private String gender;        // M: 남성, F: 여성
    private String birthdate;     // 생년월일 (YYYY-MM-DD)
    private String birthTime;     // 태어난 시간 (HH:mm)
    private String calendarType;  // S: 양력, L: 음력(평달), I: 음력(윤달)
    private String mobile;    
    private String role;          // USER, ADMIN
    private String ufile;         // 프로필 이미지 경로
    private String provider;    
    private String providerId;
    private String createdAt;  
    private String postcode;
    private String address;
    private String detailAddress;

    // 소셜 로그인용 생성자 유지
    public AppUserDto(String email, String provider) {
        this.email = email;
        this.provider = provider;
    } 
}