package com.thejoa703.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
            e.printStackTrace();  
            return 0;  
        }
    }

    @Override
    public int update(UserDto dto) {
        try {
            return dao.update(dto);
        } catch (DataAccessException e) {
            e.printStackTrace(); 
            return 0;
        }
    }

    @Override
    public int delete(UserDto dto) {
        try {
            return dao.delete(dto);
        } catch (DataAccessException e) {
            e.printStackTrace();  
            return 0;
        }
    }

    @Override
    public List<UserDto> selectAll() {
        try {
            return dao.selectAll();
        } catch (DataAccessException e) {
            e.printStackTrace();  
            return null;
        }
    }

    @Override
    public UserDto select(int appUserId) {
        try {
            return dao.select(appUserId);
        } catch (DataAccessException e) {
            e.printStackTrace();  
            return null;
        }
    }

    @Override
    public UserDto login(UserDto dto) {
        try {
            return dao.login(dto);
        } catch (DataAccessException e) {
            e.printStackTrace();  
            return null; 
        }
    }

    @Override
    public int insert2(MultipartFile file, UserDto dto) {
        String fileName = file.getOriginalFilename(); // 원본 파일 이름
        String uploadPath = "C:/file/";

        if(file.isEmpty()) { // 파일이 비어있다면
            int randomNum = (int)(Math.random() * 7) + 1; // 1~7 랜덤
            fileName = randomNum + ".png"; // 기본 확장자
        }

        File img = new File(uploadPath + fileName);
        try {
            if(!file.isEmpty()) { 
                file.transferTo(img);
            }
            dto.setUfile(fileName);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        return dao.insert2(dto);
    }


	@Override
	public int update2(MultipartFile file, UserDto dto) {
		if(!file.isEmpty()) {	// 파일이 비어있는게 아니라면
			String fileName = file.getOriginalFilename();	//원본 파일 이름
			String uploadPath = "C:/file/";
			File img = new File(uploadPath+fileName);
			try {
				file.transferTo(img);	// 파일 올리기
				dto.setUfile(fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			return dao.update2(dto);
	}

	@Override
	public int iddouble(String email) {
		try {
            return dao.iddouble(email);
        } catch (DataAccessException e) {
            e.printStackTrace();  
            return 0;
        }
	}

	@Override
	public int deleteAdmin(UserDto dto) {
		try {
            return dao.deleteAdmin(dto);
        } catch (DataAccessException e) {
            e.printStackTrace();  
            return 0; 
        }
	}

	@Override
	public int updateAdmin(UserDto dto) {
		try {
            return dao.updateAdmin(dto);
        } catch (DataAccessException e) {
            e.printStackTrace();  
            return 0; 
        }
	}
	
}
