package com.thejoa703.dao;

import java.util.HashMap;
import java.util.List;

import com.thejoa703.dto.SboardDto;

@MyDao
public interface SboardDao {
	public int insert(SboardDto dto);
	public List<SboardDto> selectAll();
	public SboardDto select(int no);
	public int update(SboardDto dto);
	public int delete(SboardDto dto);
	/* public SboardDto selectUpdateForm(int id); */
	public  int selectUpdateForm(int id);
	
	/* upload */
	public int insert2(SboardDto dto);
	public int update2(SboardDto dto);

	/* ajax */
	public List<SboardDto> selectSearch(HashMap<String, String> para);
}
