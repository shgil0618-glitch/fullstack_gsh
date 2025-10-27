<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REQUEST-요청</title>
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
		<h3 class="card-header">REQUEST-요청</h3>
		<pre class="alert alert-success">
		https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=apple&ackey=j1il9qez
		1. 처리컨테이너 (해결사 : action)				- https://search.naver.com/search.naver		<!-- ?기준 앞쪽 -->
		2. 처리방식 (get 검색/post 삽입 : method)		- get
		3. 보관용기 (넘겨줄 데이터 - 퀴리스트링 : name) - query
		</pre>
		<form action="https://search.naver.com/search.naver" method ="get" >
			<div class="mb-3 mt-3">
				<label for="search" class="form-label">naver에 물어보세요~! 검색어</label> <input
					type="search" class="form-control" id="search"
					placeholder="검색어 입력해주세요." name="query">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		
		 <pre  class="alert alert-warning">
         https://www.google.com/search?q=APPLE 
         1.처리컨테이너 : https://www.google.com/search  
         2.처리방식      : get  
         3.보관용기      : q  
      </pre>
      <form action="https://www.google.com/search  " method ="get" >
			<div class="mb-3 mt-3">
				<label for="search" class="form-label">google에 물어보세요~! 검색어</label> <input
					type="search" class="form-control" id="search"
					placeholder="검색어 입력해주세요." name="q">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>