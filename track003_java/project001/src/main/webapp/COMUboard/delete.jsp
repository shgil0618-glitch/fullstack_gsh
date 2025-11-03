<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

<%@ page import="com.thejoa703.dto.ComuDto" %>

<%
    ComuDto dto = (ComuDto) request.getAttribute("dto");
%>

<h2>게시글 삭제</h2>
<p>정말 게시글 "<%= dto.getTitle() %>"을 삭제하시겠습니까?</p>
<form action="delete.co" method="post">
    <input type="hidden" name="PostId" value="<%= dto.getPostId() %>">
    <input type="hidden" name="id" value="<%= dto.getId() %>">
    <input type="submit" value="삭제">
</form>
<a href="detail.co?PostId=<%= dto.getPostId() %>">취소</a>
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->

