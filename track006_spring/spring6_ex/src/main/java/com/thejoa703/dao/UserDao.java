package com.thejoa703.dao;

import com.thejoa703.dto.UserDto;
import java.util.List;

public interface UserDao {
    int insert(UserDto dto);
    int update(UserDto dto);
    int delete(UserDto dto);
    List<UserDto> selectAll();
    UserDto select(int appUserId);
    UserDto login(UserDto dto); // << 반드시 선언되어야 함
}
