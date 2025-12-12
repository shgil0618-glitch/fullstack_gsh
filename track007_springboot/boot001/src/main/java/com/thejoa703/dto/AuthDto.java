package com.thejoa703.dto;

import lombok.Data;

@Data
public class AuthDto {
	private int authId;
	private String email;
	private String auth;
	private int appUserId; 
}
