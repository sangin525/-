<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/board.css">
<script src="/resources/js/board/board.js"></script>
<title>BoardList</title>
</head>
<body class="Main_body">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>

	<section class="boardSection">
		
		<div class="divHead">
			<div style="display:flex; align-items:center; justify-content:center; width:200px;">
				<h1 class="boardH1">문의 사항</h1>
				
					<button style="width:60px; height:30px;" class="right-btn-board" onclick="boardEnrollBtn()">글쓰기</button>				
					<input type="hidden" id="test" value="${sessionScope.no}">
			</div>
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
							<tr class="BoardTr" onclick = "detailPage(${item.boardNo})">
								<td class="td1">${item.boardNo}</td>
								<td class="td2">${item.title}</td>
								<td class="td3">${item.name}</td>
								<td class="td4">${item.onDate}</td>
								<td class="td5">${item.views}</td>
								<td class="td6">${item.answer}</td>
							</tr>
						</c:forEach>
					</c:otherwise>

				</c:choose>

			</tbody>
		</table>

		<!-- 페이지 버튼 -->
		<ul class="pagination">
			<!-- 페이지 처리 첫번째 << 표시  -->
			<c:choose>
				<c:when test="${pi.currentPage == 1}">
					<li class="paginationLi">
						<a href="#">&laquo;</a>
					</li>
				</c:when>
			
				<c:otherwise>
					<li class="paginationLi">
						<a href="BoardList.do?cpage=${pi.currentPage-1}">&laquo;</a>
					</li>					
				</c:otherwise>
			</c:choose>
			
			<!-- 페이지 번호 -->
			<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
					<li class="paginationLi">
						<a href="/BoardList.do?cpage=${page}">${page}</a>
					</li>
			</c:forEach>
			
			<!-- 페이지 처리 첫번째 << 표시  -->
			<c:choose>
				<c:when test="${pi.currentPage == pi.maxPage}">
					<li class="paginationLi">
						<a href="#">&raquo;</a>
					</li>			
				</c:when>
				<c:otherwise>
					<li class="paginationLi">
						<a href="/BoardList.do?cpage=${pi.currentPage+1}">&raquo;</a>
					</li>			
				</c:otherwise>
			</c:choose>
		</ul>

	</section>
	<form action="/sessionTest.do" method="POST">
	</form>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>