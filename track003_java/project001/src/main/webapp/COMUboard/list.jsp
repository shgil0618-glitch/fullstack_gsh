<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@include file="../inc/header.jsp" %>

   <div class="container card  my-5 p-4">
      <h3 class="card-header"> MBTI BOARD</h3> 
 					한개			향상된 for 게시판리스트
	  <c:forEach  var="변수명"  items="서버에서넘겨받은값"  varStatus="status">
      </c:forEach>    

      
      <table class="table table-striped table-bordered table-hover">
      	<caption>mbti </caption>
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
	      	<c:forEach  var="dto"  items="${list}"  varStatus="status">
	      		<tr>	
	      			<td>${ list.size() - status.index }</td>
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
	  <p class="text-end"><a href="<%=request.getContextPath()%>/writeView.do" class="btn btn-primary">글쓰기</a></p>	
   </div>
   
<%@include file="../inc/footer.jsp" %>
 --%>
<!-- [ mbtiBoard - list.jsp ]  -->

<%@ page import="java.util.*, com.thejoa703.dto.ComuDto" %>

<h2>커뮤니티 게시판</h2>
<a href="writeView.co">글쓰기</a>
<table border="1">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>카테고리</th>
        <th>조회수</th>
        <th>작성일</th>
    </tr>
    <%
        ArrayList<ComuDto> list = (ArrayList<ComuDto>) request.getAttribute("list");
        for(ComuDto dto : list){
    %>
    <tr>
        <td><%= dto.getPostId() %></td>
        <td><a href="detail.co?PostId=<%= dto.getPostId() %>"><%= dto.getTitle() %></a></td>
        <td><%= dto.getId() %></td>
        <td><%= dto.getCategoryId() %></td>
        <td><%= dto.getViews() %></td>
        <td><%= dto.getCreatedAt() %></td>
    </tr>
    <% } %>
</table>