package com.thejoa703.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.service.MbtiDelete;
import com.thejoa703.service.MbtiDtail;
import com.thejoa703.service.MbtiEdit;
import com.thejoa703.service.MbtiEditView;
import com.thejoa703.service.MbtiInsert;
import com.thejoa703.service.MbtiList;
import com.thejoa703.service.MbtiService; 


/**
 * Servlet implementation class MbtiController
 */
//@WebServlet("*.do")
public class MbtiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MbtiController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = request.getServletPath();			// 어디로 접속했는지 알려
		System.out.println(path);
		
		MbtiService service = null; //##
		
///////////////////////////////////////////////////////
		if(path.equals("/list.do")) {
			// ■ MbtiList - 데이터 받고 처리 /         MBTIboard/list.jsp
			service = new MbtiList();  service.exec(request, response);
			request.getRequestDispatcher("MBTIboard/list.jsp").forward(request, response);
///////////////////////////////////////////////////////
		} else if(path.equals("/writeView.do")) {
			//□           /         MbTIBoard/write.jsp
			request.getRequestDispatcher("MBTIboard/write.jsp").forward(request, response);
		} else if(path.equals("/write.do")) {
			// ■ MbtiInsert /알림창 + list.do
			service = new MbtiInsert();  service.exec(request, response);
			//알림창+response.sendRedirect (x)
			//out.println("<script>alert('글쓰기에 성공했습니다.');</script>");
			//response.sendRedirect("list.do");
			String result = (String)request.getAttribute("result");
			if(result.equals("1")) {
			out.println("<script>alert('글쓰기에 성공했습니다.'); location.href='list.do';</script>");
			}else {
				out.println("<script>alert('관리자에게 문의 바랍니다.'); location.href='list.do';</script>");
			}
///////////////////////////////////////////////////////			
		} else if(path.equals("/detail.do")) {
			//■ MbtiDetail /        MbTIBoard/detail.jsp
			service = new MbtiDtail();  service.exec(request, response);
///////////////////////////////////////////////////////			
		} else if(path.equals("/editView.do")) {
			//■ MbtiUpdateView /    MbTIBoard/edit.jsp
			service = new MbtiEditView();  service.exec(request, response);
			request.getRequestDispatcher("MBTIboard/edit.jsp").forward(request, response);
		} else if(path.equals("/edit.do")) {
			//■ MbtiUpdate /알림창 + MbTIBoard/detail.jsp
			service = new MbtiEdit();  service.exec(request, response);
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			String result = (String)request.getAttribute("result");
			if(result.equals("1")) {
			out.println("<script>alert('글쓰기에 성공했습니다.'); location.href='detail.do?id="+request.getParameter("id")+"';</script>");
			}else {
				out.println("<script>alert('비밀번호를 확인해주세요.'); history.go(-1);'</script>");
			}
			///////////////////////////////////////////////////////			
		} else if(path.equals("/deleteView.do")) {
			//□           /         MbTIBoard/delete.jsp
			request.getRequestDispatcher("MBTIboard/delete.jsp").forward(request, response);
		} else if(path.equals("/delete.do")) {
			//■ MbtiDelete /알림창 + list.do
			service = new MbtiDelete();  service.exec(request, response);
			out.println("<script>alert('글쓰기에 성공했습니다.'); location.href='list.do';</script>");
		}
		
		
		
		}
}

/*
  ㄴ [전체글보기]/MBTIboard/list.do           ■ MbtiList /           MbTIBoard/list.jsp
            ㄴ [글쓰기폼]/MBTIboard/writeView.do        □           /         MbTIBoard/write.jsp
            ㄴ [글쓰기기능]/MBTIboard/write.do          ■ MbtiInsert /알림창 + list.do
            ㄴ [상세보기]/MBTIboard/detail.do           ■ MbtiDetail /        MbTIBoard/detail.jsp
            ㄴ [글수정폼]/MBTIboard/editView.do         ■ MbtiUpdateView /    MbTIBoard/edit.jsp
            ㄴ [글수정기능]/MBTIboard/edit.do           ■ MbtiUpdate /알림창 + MbTIBoard/detail.jsp
            ㄴ [글수정폼]/MBTIboard/deleteView.do       □           /         MbTIBoard/delete.jsp
            ㄴ [글수정삭제]/MBTIboard/delete.do         ■ MbtiDelete /알림창 + list.do
             
 */
