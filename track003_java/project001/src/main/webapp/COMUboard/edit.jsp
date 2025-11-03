<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>

<%@ page import="com.thejoa703.dto.ComuDto" %>

<%
    ComuDto dto = (ComuDto) request.getAttribute("dto");
%>

<h2>글 수정</h2>
<form action="edit.co" method="post">
    <input type="hidden" name="PostId" value="<%= dto.getPostId() %>">
    작성자 ID: <input type="text" name="id" value="<%= dto.getId() %>" readonly><br>
    제목: <input type="text" name="title" value="<%= dto.getTitle() %>"><br>
    내용: <textarea name="content" rows="5" cols="50"><%= dto.getContent() %></textarea><br>
    카테고리: <input type="text" name="categoryId" value="<%= dto.getCategoryId() %>"><br>
    <input type="submit" value="수정">
</form>
<a href="detail.co?PostId=<%= dto.getPostId() %>">돌아가기</a>
   
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->