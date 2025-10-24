
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container bg-primary text-white">
		<h3>WAS (WEB Application Server)</h3>
		<p>동적콘텐츠 - jsp, servlet / db연동</p>
		<p>Tomcat</p>
		<%@page import="java.util.Calendar"%>
		<%
			Calendar today = Calendar.getInstance();	//ctrl+space (Import)
			String now =" " + today.get(1) + (today.get(2)+1) + today.get(5);
			out.println(now);
		%>
		<p></p>
	</div>
</body>
</html>