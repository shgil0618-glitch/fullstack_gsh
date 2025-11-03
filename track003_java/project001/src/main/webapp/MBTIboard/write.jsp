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
	<div class="container card  my-5 p-4">
		<h3 class="card-header">mbti 글쓰기</h3>
		<form action="<%=request.getContextPath()%>/write.do" method="post">
		<input type="hidden" name="app_user_id" value="">
			<div class="mb-3 mt-3">
				<label for="title" class="form-label">TITLE:</label> <input
					type="text" class="form-control" id="title"
					placeholder="내용을 입력하세요" name="title" >		
			</div>
			<div class="mb-3">
				<label for="pass" class="form-label">PASS:</label> <input
					type="password" class="form-control" id="pass"
					placeholder="비밀번호를 입력해주세요" name="pass">
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">CONTENT:</label> 
				<textarea class="form-control" id="content"
					placeholder="내용을 입력하세요" name="content"></textarea>
			</div>
			<div class="mb-3 text-end">
			<button type="submit" class="btn btn-primary">글쓰기</button>
			<a href="<%=request.getContextPath()%>/list.do" class = "btn btn-primary">목록보기</a>
			</div>
		</form>
	</div>
	<%@include file ="../inc/footer.jsp" %>
</body>
</html>