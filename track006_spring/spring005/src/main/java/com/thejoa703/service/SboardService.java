package com.thejoa703.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.SboardDto;

public interface SboardService {
	public int insert(SboardDto dto);	// board insert 기능
	public int update(SboardDto dto);	// board update 기능
	public int delete(SboardDto dto);			// board delete 기능 
	public List<SboardDto> selectAll();	// board 전체보기
	public SboardDto select(int id);	// board 상세보기 (조회수 올리기 + 해당글 가져오기)
	public SboardDto selectUpdateForm(int id);
	
	/* upload */
	public int insert2(MultipartFile file ,SboardDto dto);
	public int update2(MultipartFile file ,SboardDto dto);
	
	/* search-ajax */
	public List<SboardDto> selectSearch(String keyword);
}
