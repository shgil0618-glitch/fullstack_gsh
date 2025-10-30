  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    
<%@include file="../inc/header.jsp" %> 
   <div class="container card  my-5 p-4">
      <h3 class="card-header"> MBTI 글상세보기</h3>
	  <div> 
	      <input type="hidden"   name="app_user_id"  value=""> 
		  <div class="mb-3 mt-3">
		    <label for="hit" class="form-label">조회수</label>
		    <input type="email" class="form-control" id="hit" name="hit"  readonly  value="">
		  </div> 
		  <div class="mb-3 mt-3">
		    <label for="title" class="form-label">TITLE:</label>
		    <input type="email" class="form-control" id="title" 
		    		placeholder="내용을 입력해주세요" name="title"  readonly  value="">
		  </div>  
		  <div class="mb-3">
		    <label for="content" class="form-label">CONTENT:</label>
		    <textarea class="form-control" id="content" placeholder="내용을 입력해주세요"   
		    	readonly name="content"></textarea>
		  </div> 
		  <div class="mb-3">
		  	<a href="<%=request.getContextPath()%>/editView.do" class="btn btn-success form-control">글수정</a>
		  </div>
		  <div class="mb-3">
		  	<a href="<%=request.getContextPath()%>/deleteView.do" class="btn btn-secondary form-control">글삭제</a>
		  </div>
		  <div class="mb-3">
		  	<a href="<%=request.getContextPath()%>/list.do" class="btn btn-primary form-control">목록보기</a>
		  </div>
	 </div>
   </div> 
<%@include file="../inc/footer.jsp" %>
<!-- [ mbtiBoard - list.jsp ]  -->
</body>
</html>