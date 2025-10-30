<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
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
	<div class="container card  my-5">
		<h3 class="card-header">MBTI 글삭제</h3>
		<form action="<%=request.getContextPath()%>/delete.do" method="post">
			<input type="hidden" name="app_user_id" value="">
			<div class="my-3">
				<label for="pass" class="form-label">PASS:</label> <input
					type="password" class="form-control" id="pass"
					placeholder="비밀번호를 입력해주세요" name="pass">
			</div>
			<div class="my-3 text-end" >
				<button type="submit" class="btn btn-primary">글삭제</button>
				<a href="javascript:history.go(-1)" class="btn btn-danger">BACK</a>
			</div>
		</form>
	</div>
	<%@include file ="../inc/footer.jsp" %>
</body>
</html>