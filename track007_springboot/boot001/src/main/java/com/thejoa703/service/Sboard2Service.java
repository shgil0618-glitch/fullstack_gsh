package com.thejoa703.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.Sboard2Dto;


public interface Sboard2Service {
	
	public int insert(MultipartFile file, Sboard2Dto dto);
	public int update(MultipartFile file, Sboard2Dto dto);
	public int delete(Sboard2Dto dto);
	public List<Sboard2Dto> selectAll();
	public Sboard2Dto select(int id);	//조회수올리기 + 상세보기
	public Sboard2Dto selectUpdateForm(int id);	//수정하기폼

	


	

	
}
