<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file ="../inc/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card  my-5">
      <h3  class="card-header"> MBTI BOARD </h3>
 <%--      			 한개			향상된 for 게시판리스트
      <c:forEach var="변수명" items="서버에서 넘겨받은 값들" varStatus="status">
      </c:forEach> list.size()
  --%>     
		<table class ="table table-striped table-bordered table-hover">
		<caption>mbti</caption>
		<thead>
			<tr>
				<th scope="col">NO</th>
				<th scope="col">TITLE</th>
				<th scope="col">NAME</th>
				<th scope="col">DATE</th>
				<th scope="col">HIT</th>
			</tr>
		</thead>
		<tbody>
	  		<c:forEach var="dto" items="${list}" varStatus="status">
	  			<tr>
	  				<td>${list.size() - status.index}</td>
	  				<td>
	  				<a href="<%=request.getContextPath()%>/detail.do?id=${dto.id}">
	  				${dto.title}
	  				</a>
	  				</td>
	  				<td>${dto.email}</td>
	  				<td>${dto.createdAt}</td>
	  				<td>${dto.hit}</td>
	  			</tr>
      		</c:forEach> 
		</tbody>
		</table>
		<p class="text-end"><a href="<%=request.getContextPath()%>/writeView.do" class ="btn btn-primary">글쓰기</a></p>
   </div>
       <%@include file ="../inc/footer.jsp" %>
</body>
</html>