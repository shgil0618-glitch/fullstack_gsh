package com.thejoa703.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thejoa703.dao.UserDao;
import com.thejoa703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public int insert(UserDto dto) {
        return dao.insert(dto);
    }

    @Override
    public int update(UserDto dto) {
        return dao.update(dto);
    }

    @Override
    public int delete(UserDto dto) {
        return dao.delete(dto);
    }

    @Override
    public List<UserDto> selectAll() {
        return dao.selectAll();
    }

    @Override
    public UserDto select(int appUserId) {
        return dao.select(appUserId);
    }

    @Override
    public UserDto login(UserDto dto) {
        return dao.login(dto);
    }
}
