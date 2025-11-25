<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>

<script>
	$(function() {
		let success = '${success}';
		let error = '${error}';

		if (success) {
			alert(success);
		} else if (error) {
			alert(error);
			history.go(-1); // 실패 시 뒤로
		}
	});
</script>

<div class="container card my-5">
	<h3 class="card-header">MYPAGE</h3>
	<table class="table table-striped table-bordered table-hover">
		<tbody class="table-info">

			<!-- 이미지 + Email -->
			<tr>
				<th scope="row" rowspan="4"
					style="vertical-align: middle; text-align: center; width: 160px; ">
					<img src="${pageContext.request.contextPath}/upload/${dto.ufile}"
					alt="user image"
					style="width: 150px; height: 100%; object-fit: cover; border-radius: 6px;" />
				</th>
				<td>Email</td>
				<td>${dto.email}</td>
			</tr>

			<!-- MBTI -->
			<tr>
				<td>MBTI TYPE</td>
				<td>${dto.mbtiTypeId}</td>
			</tr>

			<!-- 가입날짜 -->
			<tr>
				<td>회원가입날짜</td>
				<td>${dto.createdAt}</td>
			</tr>

			<!-- Password -->
			<tr>
				<td>Password</td>
				<td>
					<%
					com.thejoa703.dto.UserDto dto = (com.thejoa703.dto.UserDto) request.getAttribute("dto");
					if (dto != null) {
						String password = dto.getPassword();
						if (password != null && password.length() > 0) {
							out.print(password.charAt(0));
							for (int i = 1; i < password.length(); i++) {
						out.print("*");
							}
						} else {
							out.print("");
						}
					} else {
						out.print("");
					}
					%>
				</td>
			</tr>

		</tbody>

	</table>
	<div style="text-align: right; margin-top: 10px;">
		<button type="submit" class="btn btn-danger btn-sm">
			<a style="text-decoration: none; color: white;"
				href="${pageContext.request.contextPath}/edit.user?appUserId=${dto.appUserId}">수정</a>
		</button>
		<form action="${pageContext.request.contextPath}/delete.user"
			method="post" onsubmit="return confirm('정말 삭제하시겠습니까?');">
			<input type="hidden" name="appUserId" value="${dto.appUserId}" /> <input
				type="password" name="password" placeholder="비밀번호" required />
			<button type="submit" class="btn btn-danger btn-sm">삭제</button>
		</form>
	</div>
</div>
<%@ include file="../../inc/footer.jsp"%>
