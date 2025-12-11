package com.thejoa703.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.Sboard2Dto;


@Mapper
public interface Sboard2Dao {
	

	public int insert(Sboard2Dto dto);
	public int update(Sboard2Dto dto);
	public int delete(Sboard2Dto dto);
	public List<Sboard2Dto> selectAll();
	public Sboard2Dto select(int id);
	public int updateHit(int id);	
	public List<Sboard2Dto> select10(HashMap<String,Integer> para);
	public int selectTotalCnt();
	
	   // 검색 조건으로 전체 개수
	public int countSearch(String keyword);

    // 검색 + 페이징 리스트
	public List<Sboard2Dto> searchList(Map<String, Object> map);


	
}
