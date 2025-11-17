package com.thejoa703.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.thejoa703.dao.UserDao;
import com.thejoa703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public int insert(UserDto dto) {
        try {
            return dao.insert(dto);
        } catch (DataAccessException e) {
            e.printStackTrace();  // 데이터베이스 예외 처리
            return 0;  // 실패 시 0을 리턴
        }
    }

    @Override
    public int update(UserDto dto) {
        try {
            return dao.update(dto);
        } catch (DataAccessException e) {
            e.printStackTrace();  // 예외 로그 남기기
            return 0;
        }
    }

    @Override
    public int delete(UserDto dto) {
        try {
            return dao.delete(dto);
        } catch (DataAccessException e) {
            e.printStackTrace();  // 예외 로그 남기기
            return 0;
        }
    }

    @Override
    public List<UserDto> selectAll() {
        try {
            return dao.selectAll();
        } catch (DataAccessException e) {
            e.printStackTrace();  // 예외 로그 남기기
            return null;
        }
    }

    @Override
    public UserDto select(int appUserId) {
        try {
            return dao.select(appUserId);
        } catch (DataAccessException e) {
            e.printStackTrace();  // 예외 로그 남기기
            return null;
        }
    }

    @Override
    public UserDto login(UserDto dto) {
        try {
            return dao.login(dto); // 로그인 메소드
        } catch (DataAccessException e) {
            e.printStackTrace();  // 예외 로그 남기기
            return null;  // 로그인 실패시 null 리턴
        }
    }
}
