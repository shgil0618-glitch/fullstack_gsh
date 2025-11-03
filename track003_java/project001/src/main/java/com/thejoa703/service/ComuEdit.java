package com.thejoa703.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dao.ComuDao;
import com.thejoa703.dto.ComuDto;



public class ComuEdit implements ComuService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.데이터 넘겨받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int postId = Integer.parseInt(request.getParameter("postId"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		/*
		 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, dto.getTitle());
		 * pstmt.setString(2, dto.getContent()); pstmt.setInt(3, dto.getCategoryId());
		 * pstmt.setInt(4, dto.getPostId()); pstmt.setInt(5, dto.getId());
		 */
		System.out.println(".........1 : "+id);
		// 2. 드커프리
		ComuDto dto = new ComuDto();
		ComuDao dao = new ComuDao();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setCategoryId(categoryId);
		dto.setPostId(postId);
		dto.setId(id);
		
		System.out.println(".........2 : "+dto);
		// 3. 데이터 넘기기
		request.setAttribute("PostId", postId);
		request.setAttribute("result", String.valueOf(dao.update(dto)));

	}

}
