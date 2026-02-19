package com.thejoa703.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thejoa703.service.EventService;
import com.thejoa703.service.EventServiceImpl;

@WebServlet("*.do") // .do 패턴으로 모든 요청 수신
public class EventController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EventService eventService = new EventServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        String view = "/WEB-INF/views/main.jsp"; // 기본 뷰

        try {
            if (path.equals("/joinEvent.do")) {
                // 1. 이벤트 참가 요청
                String phone = request.getParameter("phoneNumber");
                Map<String, Object> result = eventService.joinEvent(phone);
                
                request.setAttribute("result", result);
                view = "/WEB-INF/views/joinResult.jsp";

            } else if (path.equals("/checkResult.do")) {
                // 2. 당첨 결과 확인 요청
                String phone = request.getParameter("phoneNumber");
                Map<String, Object> winInfo = eventService.checkWinningResult(phone);
                
                request.setAttribute("winInfo", winInfo);
                view = "/WEB-INF/views/announceResult.jsp";
            }

            // 결과 페이지로 포워딩
            request.getRequestDispatcher(view).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}