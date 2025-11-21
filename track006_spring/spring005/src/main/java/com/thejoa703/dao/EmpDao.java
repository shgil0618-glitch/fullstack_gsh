package com.thejoa703.dao;

import java.util.List;
import java.util.Map;

import com.thejoa703.dto.EmpDto;

@MyDao
public interface EmpDao {
	public List<EmpDto>  test1 (Map<String,String> para);
}
