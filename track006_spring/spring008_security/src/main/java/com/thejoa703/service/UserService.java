package com.thejoa703.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.UserDto;


public interface UserService {
	public int insert(UserDto dto);	
	public int update(UserDto dto);	
	public int delete(UserDto dto);			 
	public List<UserDto> selectAll();	
	public UserDto select(int appUserId);	
	public UserDto login(UserDto dto);
	
	//이미지 업로드
	public int insert2( MultipartFile file ,UserDto dto);
	public int update2( MultipartFile file ,UserDto dto);
	 
	/* iddouble */
	public int iddouble(String email);
	
	/* 관리자용 */
	public int deleteAdmin(UserDto dto);
    public int updateAdmin(UserDto dto);
    
}
