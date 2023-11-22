<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/board.css">

<title>BoardList</title>
</head>
<body class ="Main_body">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>

	<section class="boardSection">
		<div class="divHead">
			<h1 class="boardH1">문의 사항</h1>
			<button class="boardBtn" onClick="location.href= 'boardEnroll.jsp'">글쓰기</button>
		</div>

		<table>
			<thead>
				<th class="th1">게시물 번호</th>
				<th class="th2">제목</th>
				<th class="th3">작성자</th>
				<th class="th4">작성날짜</th>
			</thead>
			<hr>
			<tbody>
				<td class="td1">1</td>
				<td class="td2">1</td>
				<td class="td3">1</td>
				<td class="td4">1</td>
			</tbody>
		</table>

		<ul class="pagination">
			<li class="paginationLi"><a href=""> << </a></li>
			<li class="paginationLi"><a href=""> 1 </a></li>
			<li class="paginationLi"><a href=""> >> </a></li>
		</ul>

	</section>
	<a href="./boardEnroll.jsp">boardEnroll</a>
	<a href="./boardDetail.jsp">boardDetail.jsp</a>
	<form action="/sessionTest.do" method="POST">
		<button type="submit">Session Test</button>
	</form>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>