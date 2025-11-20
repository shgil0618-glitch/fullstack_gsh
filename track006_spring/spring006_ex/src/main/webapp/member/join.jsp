<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/header.jsp"%>
<!-- 	header		 --> 
<div class="container mt-5">
	<h3>WELCOME! 회원가입</h3>
	<form action="${pageContext.request.contextPath}/join2.user"  method="post" encType="multipart/form-data">
		<div class="mb-3 mt-3">
			<label  for="email" class="form-label">Email:</label> 
			<input  type="email" class="form-control" id="email"
					placeholder="이메일을 입력해주세요" required  name="email">
			<div class="iddouble_result">
		
            </div>
			<script >
			$(function(){
				// 1. 대상찾아오기 아이디가 이메일의 값을 찾아오려고함.
				$('#email').on("keyup",function(){
					console.log($(this).val().trim());
					let keyword = $(this).val().trim();
					if(keyword===""){// 빈칸인지 검사
						//	===로 비교하는 이유는 ==는 비교시 boolean 형태(true/false)로 자동 변환되기 때문에
						$(".iddouble_result").empty().append("<span class='test-danger' p-3>이메일을 입력해주세요</span>");
						return;
					}else {// 아니라면 ajax
						$.ajax({
		                    url:"${pageContext.request.contextPath}/iddouble",
		                    type:"POST",		//GET,POST,PUT
		                    data:{  search : keyword },
		                    success:function(res){
		                    console.log(res);
							if(res.cnt==1){
								$(".iddouble_result").empty().append("<span class='test-danger' p-3>이미 사용중인 이메일 입니다.</span>");
							}else{
								$(".iddouble_result").empty().append("<span class='test-danger' p-3>사용가능한 이메일입니다.</span>");
							}           
		                    }, error:function(){
		                    	$(".iddouble_result").empty().append("<span class='test-danger' p-3>서버 요청중 오류가 발생햇습니다.</span>");
		                    }
		                 });
					}
				});
				
				// 2. 
			});
			</script>		
				
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password:</label> 
			<input type="password" class="form-control" id="password"
					placeholder="비밀번호를 입력해주세요" name="password">
		</div>
		<div class="mb-3">
			<label class="form-check-label"  for="mbtiTypeId">MBTI TYPE : </label>  
			<select   name="mbtiTypeId"  id="mbtiTypeId"  class="form-control">
				<option value="1">ISTJ</option>
				<option value="2">ISFJ</option>
				<option value="3">INFJ</option>
			</select>
		</div>
		 <div class="mb-3">
		    <label for="file" class="form-label">file:</label>
		    <input type="file" class="form-control" id="file" placeholder="파일을 입력해주세요" name="file"></input>
		  </div> 
		  
		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</div>
<!-- ctrl + shift + f -->
<!-- 	footer		 --> 
<%@ include file="../inc/footer.jsp"%>





	
<!-- 				
	action="join_process.jsp"
	method="post"
	name="email"   name="password"  name="mbti_type_id" 
-->
