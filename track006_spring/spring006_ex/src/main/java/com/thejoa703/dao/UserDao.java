package com.thejoa703.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.UserDto;

@MyDao
public interface UserDao {

    int insert(UserDto dto);
    int update(UserDto dto);
    int delete(UserDto dto);
    List<UserDto> selectAll();
    UserDto select(int appUserId);
    UserDto login(UserDto dto); // 이메일, 비밀번호로 로그인 처리
}
