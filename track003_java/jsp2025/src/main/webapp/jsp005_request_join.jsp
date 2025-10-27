<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
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
		<h3 class="card-header">회원가입</h3>
		<pre class="alert alert-success">
      	1. 처리컨테이너 - jsp005_result.jsp
      	2. 처리방식	 - post
      	3. 보관용기	 - email , password, mbti_type_id
      </pre>
		<form action="jsp005_result.jsp" method = "post">
			<div class="mb-3 mt-3">
				<label for="email" class="form-label">Email:</label> <input
					type="email" class="form-control" id="email" 
					required placeholder="Enter email" name="email">
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">Password:</label> <input
					type="password" class="form-control" id="pwd"
					required placeholder="Enter password" name="password">
			</div>
			<div class="mb-3">
				<label for="mbti" class="form-label">mbti 유형:</label> 
				<select id="mbti" name="mbti_type_id" required class ="form-control">
				<option value="1">ISTJ</option>
				<option value="2">ISFJ</option>
				<option value="3">INFJ</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		
		
	 <pre class="alert alert-success my-3">
      1. 처리할 경로 : jsp006_result.jsp
      2. 주소표시창줄에 노출 안됨
      3. 보관용기이름 :  email   / password
      </pre>
      
      <form action="jsp006_result.jsp" method = "post">
			<div class="mb-3 mt-3">
				<label for="email" class="form-label">Email2:</label> <input
					type="email" class="form-control" id="email2" 
					required placeholder="Enter email" name="email2">
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">Password2:</label> <input
					type="password" class="form-control" id="pwd"
					required placeholder="Enter password" name="password2">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>

<!-- 
			사용자	관리자
CREATE		회원가입	회원가입
READ		로그인	로그인 / 아이디찾기,비번찾기
UPDATE		정보수정	정보수정
DELETE		탈퇴		탈퇴
 -->