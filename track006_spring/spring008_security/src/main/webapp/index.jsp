<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%  response.sendRedirect( request.getContextPath()  + "/list.quest"); %> --%>
<div class="container panel panel-info">
	<h3 class="panel-heading">security</h3>	
	<p><a href="${pageContext.request.contextPath}/security/all">All - 모든 사람들 접근가능</a></p>
	<p><a href="${pageContext.request.contextPath}/security/member">Member - 멤버만 접근가능</a></p>
</div>