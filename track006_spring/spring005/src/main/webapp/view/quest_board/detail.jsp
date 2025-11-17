<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %> 
<script>
	$(function(){
		let result = '${success}';
		console.log(result);
		if(result=="비밀번호 실패") {alert(result); history.go(-1);}
		else if (result=="수정 성공") {alert(result);}
	});
	</script>
   <div class="container card  my-5 p-4">
      <h3 class="card-header"> MBTI  QUEST 상세보기</h3>
	  <div> 
	      <input type="hidden"   name="id"  value="${dto.id}"> 
		  <div class="mb-3 mt-3">
		    <label for="bhit" class="form-label">조회수</label>
		    <input type="text" class="form-control" id="bhit" name="bhit"  readonly   value="${dto.bhit}">
		  </div> 
		  <div class="mb-3 mt-3">
		    <label for="btitle" class="form-label">TITLE:</label>
		    <input type="text" class="form-control" id="btitle" 
		    		placeholder="내용을 입력해주세요" name="btitle"  readonly  value="${dto.btitle}">
		  </div>  
		  <div class="mb-3">
		    <label for="bcontent" class="form-label">CONTENT:</label>
		    <textarea class="form-control" id="bcontent" placeholder="내용을 입력해주세요"   
		    	readonly name="bcontent">${dto.bcontent}</textarea>
		  </div> 
		   
			<div class="mb-3">
			<a href="${pageContext.request.contextPath}/edit.quest?id=${dto.id}" class="btn btn-success form-control">글수정</a>
			</div>
			<div class="mb-3">
			<a href="${pageContext.request.contextPath}/delete.quest?id=${dto.id}" class="btn btn-secondary form-control">글삭제</a>
			</div> 
		
		  
		  <div class="mb-3">
		  	<a href="${pageContext.request.contextPath}/list.quest" class="btn btn-primary form-control">목록보기</a>
		  </div>
	 </div>
   </div> 
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->