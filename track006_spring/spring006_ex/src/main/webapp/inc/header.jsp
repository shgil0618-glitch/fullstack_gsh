<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap 5 Website Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
</head>
<body>

<div class="p-5 bg-primary text-white text-center">
  <h1>MBTI Quest Board</h1>
  <p>각종 보드들의 기능익히기 - PAGING + UPLOAD + BOARD</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav"> 

	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/logout.user?appUserId=${appUserId}">로그아웃</a>
	      </li>   
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/login.user">LOGIN</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/join.user">JOIN</a>
	      </li>    
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/mypage.user">${dto.email} page </a>
	      </li>  
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/list.user">전체회원 보기</a>
	      </li>    
    </ul> 
    <%-- <ul class="navbar-nav">
        <% 
            String email = (String)session.getAttribute("email");  
            Integer sid = (Integer)session.getAttribute("appUserId"); 
            if(email != null){ %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" 
                   data-bs-toggle="dropdown"><%=email%></a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="<%=request.getContextPath()%>/mypage.do">마이페이지</a></li>
                  <li><a class="dropdown-item" href="<%=request.getContextPath()%>/잡기능.do">마이페이지</a></li>
                  <li><a class="dropdown-item" href="<%=request.getContextPath()%>/잡기능.do">마이페이지</a></li>
                  <li><a class="dropdown-item" href="<%=request.getContextPath()%>/잡기능.do">마이페이지</a></li>
                  <li><a class="dropdown-item" href="<%=request.getContextPath()%>/잡기능.do">마이페이지</a></li>        
                </ul>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/logout.do">로그아웃</a>
              </li>
        <% } else { %>
              <li class="nav-item">
                
                <a class="nav-link" href="<%=request.getContextPath()%>/loginForm.do">LOGIN</a>
                <a class="nav-link" href="<%=request.getContextPath()%>/view/UserLogin.jsp">LOGIN</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/view/UserJoin.jsp">회원가입</a>
              </li>
        <% } %>
      </ul> --%>
  </div>
</nav>
<!-- 	header		 -->
<!-- 	header		 -->
<!-- 	header		 -->
    