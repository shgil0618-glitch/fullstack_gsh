package com.thejoa703.dto;

import lombok.Data;

@Data
public class AppUserDto {
	private int appUserId;	//pk
	private String  email;
	private String password;
	private int mbtiTypeId;
	private String createdAt;
	private String ufile;
	private String mobile;
	private String nickname;
	private String provider;	//google, kakao, naber, local...
	private String providerId;	// 각 provider의 고유 id
}
