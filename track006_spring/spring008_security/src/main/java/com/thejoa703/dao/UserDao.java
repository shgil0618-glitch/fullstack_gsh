package com.thejoa703.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.UserDto;

@MbtiDao
public interface UserDao {

    public int insert(UserDto dto);
    public int update(UserDto dto);
    public int delete(UserDto dto);
    public List<UserDto> selectAll();
    public UserDto select(int appUserId);
    public UserDto login(UserDto dto); // 이메일, 비밀번호로 로그인 처리
    
    //이미지 추가
    public int insert2(UserDto dto);
    public int update2(UserDto dto);
    
	/* iddoutble */
    public int iddouble(String email);
    
    /*관리자 삭제 조회*/
    public int deleteAdmin(UserDto dto);
    public int updateAdmin(UserDto dto);
    
}
