package com.company.jsp009servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBasic3_LifrCycle
 */
@WebServlet("/ServletBasic3_LifrCycle")
public class ServletBasic3_LifrCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	int  initcnt = 1;	//init 맨처음 한번만
	int doGetCNT = 1;	//Thread-get/post 
	int destroycnt = 1;	// destory 맨마지막 한번만
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBasic3_LifrCycle() { super(); }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("#1. init() 첫요청에만 호출 > " + initcnt++);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("#3. destory() 맨마지막에만 호출 > " + destroycnt++);		//개발자가 코드 수정시 호출되네..
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("GOOD :DAY").append(request.getContextPath());
		System.out.println("#2.                              호출될때마다...재사용 > " + doGetCNT++);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
