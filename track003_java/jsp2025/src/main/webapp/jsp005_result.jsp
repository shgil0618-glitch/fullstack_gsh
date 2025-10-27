<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>REQUEST</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card  my-5">
      <h3  class="card-header"> JOIN RESULT </h3>
      <pre class="alert alert-success">
      CLIENT (요청 : REQUEST) ↔ SERVER(응답 : RESPONSE)
      2. 									request.getParameter("name이름")
      </pre>
	  <%    
	  String email = request.getParameter("email");
	  String password = request.getParameter("password");
	  String mbti_type_id = request.getParameter("mbti_type_id");  
	  %>
	  <p>이메일 - <%=email%> </p>		<!-- 표현식 =email (출력) -->
	  <p>비밀번호 - <%=password%> </p>
	  <p>mbti유형 - <%=mbti_type_id%> </p>
   </div>
</body>
</html>