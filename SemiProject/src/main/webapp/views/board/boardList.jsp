<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/board.css">

<title>BoardList</title>
</head>
<body class="Main_body">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>

	<section class="boardSection">
		<div class="divHead">
			<h1 class="boardH1">문의 사항</h1>
			<button class="boardBtn"
				onClick="location.href= 'views/board/boardEnroll.jsp'">글쓰기</button>
		</div>

		<table class="boardTable">
			<thead class="boardThead">
				<th class="th1">게시물 번호</th>
				<th class="th2">제목</th>
				<th class="th3">작성자</th>
				<th class="th4">작성날짜</th>
				<th class="th5">조회수</th>
				<th class="th6">답변여부</th>
			</thead>
			<tbody class="boardTbody">
				<c:choose>
					<c:when test="${empty list}">
						<tr>
							<td colspan="6" class="tdEmpty">등록된 글이 없습니다.</td>
						</tr>
					</c:when>

					<c:otherwise>
						<c:forEach var="item" items="${list}">
							<tr onclick = "detailPage(${item.boardNo})">
							<!-- 위에 자바스크립트로 작업해야함 -->
								<td class="td1">${item.boardNo}</td>
								<td class="td2">${item.title}</td>
								<td class="td3">작성자</td>
								<td class="td4">${item.onDate}</td>
								<td class="td5">1</td>
								<td class="td6">-</td>
							</tr>
						</c:forEach>
					</c:otherwise>

				</c:choose>

			</tbody>
		</table>

		<!-- 페이지 버튼 -->
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