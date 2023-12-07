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
<body class="Main_body" style = "background-color:white;">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>

	<section class="boardSection">
		<!-- 문의사항 글자 및 글쓰기 버튼 div -->
		<div class="divSort">
			<div>
				<h1 class="boardH1">문의 사항</h1>
				<p style="margin-left:25px;">호텔 하루를 이용해주시는 고객님들의 문의사항을 확인해보실 수 있습니다.</p>
			</div>
			<div style="align-self: flex-start;">		
				<button style="width:60px; height:30px;" class="right-btn-board" onclick="boardEnrollBtn()">글쓰기</button>				
				<input type="hidden" id="test" value="${sessionScope.no}">
			</div>
		</div>
		
		<div class="divSort3">
			<input placeholder ="검색어를 입력해주세요">
			<button>검색</button>
		</div>
		
		<!-- 버튼 모음 -->
		<div class="divSort2">
			<button class="SortBtn">전체</button>
			<button class="SortBtn">객실 문의</button>
			<button class="SortBtn">예약 문의</button>
			<button class="SortBtn">시설 문의</button>
			<button class="SortBtn">회원 가입 및 로그인 문의</button>
			<button class="SortBtn">기타 문의</button>
		</div>
		
		<!-- Table 본문 -->
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
					<li class="page-item">
						<a href="#" class ="page-link">&laquo;</a>
					</li>
				</c:when>
			
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="BoardList.do?cpage=${pi.currentPage-1}">&laquo;</a>
					</li>					
				</c:otherwise>
			</c:choose>
			
			<!-- 페이지 번호 -->
			<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
				<c:if test="${pi.currentPage == page}">
					<li class="page-item-active">
						<a class="page-link" href="/BoardList.do?cpage=${page}">${page}</a>
					</li>
				</c:if>
				<c:if test="${pi.currentPage != page}">
					<li class="page-item">
						<a class="page-link" href="/BoardList.do?cpage=${page}">${page}</a>
					</li>
				</c:if>
				
			</c:forEach>
			
			<!-- 페이지 처리 첫번째 << 표시  -->
			<c:choose>
				<c:when test="${pi.currentPage == pi.maxPage}">
					<li class="page-item">
						<a class="page-link" href="#">&raquo;</a>
					</li>			
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="/BoardList.do?cpage=${pi.currentPage+1}">&raquo;</a>
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