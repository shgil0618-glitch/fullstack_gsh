package com.thejoa703.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AuthDto;
import com.thejoa703.dto.UserDto;

@MbtiDao
public interface UserDao {

    public int insert(UserDto dto);
    public int update(UserDto dto);
    public int delete(UserDto dto);
    public List<UserDto> selectAll();
    public UserDto select(int appUserId);
    public UserDto  selectEmail(String email);
    public UserDto login(UserDto dto); // �̸���, ��й�ȣ�� �α��� ó��
    
    //�̹��� �߰�
    public int insert2(UserDto dto);
    public int update2(UserDto dto);
    
    public int insert3(MultipartFile file, UserDto dto);
    
	/* iddoutble */
    public int iddouble(String email);
    
    /*������ ���� ��ȸ*/
    public int deleteAdmin(UserDto dto);
    public int updateAdmin(UserDto dto);
    
    /* security */
    /* security */
    public int insertAuth(AuthDto dto);
    public AppUserAuthDto readAuth (AppUserAuthDto dto);
    
    
}
