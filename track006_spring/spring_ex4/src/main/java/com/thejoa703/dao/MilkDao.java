package com.thejoa703.dao;

import java.util.List;

import com.thejoa703.dto.MilkDto;

@MyDao
public interface MilkDao {
	public int insert(MilkDto dto);
	public List<MilkDto> selectAll();
	public MilkDto select(int no);
	public int update(MilkDto dto);
	public int delete(int no);
}
