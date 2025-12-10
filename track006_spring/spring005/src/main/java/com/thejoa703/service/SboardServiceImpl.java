package com.thejoa703.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	//    dao.selectUpdateForm(id); // ��ȸ�� 1 ����
		dao.updateHit(id);
		dao.select(id);
	    return dao.select(id);    // �� ���� ��������
	}

	@Override public SboardDto selectUpdateForm(int id) { return dao.select(id);
	 }

	/* upload */
	@Override
	public int insert2(MultipartFile file, SboardDto dto) {
		if(!file.isEmpty()) {	// ������ ����ִ°� �ƴ϶��
			String fileName = file.getOriginalFilename();	//���� ���� �̸�
			String uploadPath = "C:/file/";
			File img = new File(uploadPath+fileName);
			try {
				file.transferTo(img);	// ���� �ø���
				dto.setBfile(fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return dao.insert2(dto); }

	@Override
	public int update2(MultipartFile file, SboardDto dto) {
		if(!file.isEmpty()) {	// ������ ����ִ°� �ƴ϶��
			String fileName = file.getOriginalFilename();	//���� ���� �̸�
			String uploadPath = "C:/file/";
			File img = new File(uploadPath+fileName);
			try {
				file.transferTo(img);	// ���� �ø���
				dto.setBfile(fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return dao.update2(dto);
	}

	@Override
	public List<SboardDto> selectSearch(String keyword) {
		HashMap<String,String> para = new HashMap<>();
		para.put("search", "%" + keyword+"%");
		return dao.selectSearch(para);
	}

	
	

}
