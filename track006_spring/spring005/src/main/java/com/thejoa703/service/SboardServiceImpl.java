package com.thejoa703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thejoa703.dao.SboardDao;
import com.thejoa703.dto.SboardDto;

@Service
public class SboardServiceImpl implements SboardService {

	@Autowired SboardDao dao;
	@Override
	public int insert(SboardDto dto) { 
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return dao.insert(dto); }

	@Override
	public int update(SboardDto dto) { return dao.update(dto); }

	@Override
	public int delete(SboardDto dto) { return dao.delete(dto); }

	@Override
	public List<SboardDto> selectAll() { return dao.selectAll(); }

	@Override
	public SboardDto select(int id) { 
	    dao.selectUpdateForm(id); // 조회수 1 증가
	    return dao.select(id);    // 글 정보 가져오기
	}


	
	
	@Override public SboardDto selectUpdateForm(int id) { return dao.select(id);
	 }
	 
	

}
