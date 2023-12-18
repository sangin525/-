<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/board.css">
<script src="/resources/js/board/board.js"></script>
<title>Notice List</title>
</head>
<body class="boardBody">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>

	<section class="boardNoticeSection">
		<!-- 문의사항 글자 및 글쓰기 버튼 div -->
		<div class="divSort">
			<div>
				<h1 class="boardH1">공지 사항</h1>
				<p style="margin-left:25px;">호텔 하루의 소식을 공지사항에서 확인해보실 수 있습니다.</p>
			</div>
			<div style="align-self: flex-start;">	
				<!-- 이 부분에 admin만 추가 가능한 조건 삽입하기-->	
				<c:if test="${sessionScope.admin eq 'Y'}">
					<button class="right-btn-board-Enroll" onclick="noticeEnrollBtn()"> <img class="btnStyle" src="/resources/boardIcon/file-earmark-plus.svg"> 글 쓰기</button>				
				</c:if>
				<input type="hidden" id="test" value="${sessionScope.no}">
			</div>
		</div>
		
		<div class="divSort3" style="margin-bottom:0;">
			<input class="divSort3Input" placeholder ="검색어를 입력해주세요" id="searchNoticeBtn" onkeypress="if(window.event.keyCode==13){searchNotice()}">
			<button onclick ="searchNotice()">검색</button>
		</div>
		
		<!-- Table 본문 -->
		<table class="boardTable">
			<thead class="boardThead">
				<th class="th1">게시물 번호</th>
				<th class="th2">제목</th>
				<th class="th3">작성자</th>
				<th class="th4">작성날짜</th>
				<th class="th5">조회수</th>
			</thead>
			<tbody class="boardTbody">
				<c:choose>
					<c:when test="${empty list}">
						<tr>
							<td colspan="5" class="tdEmpty">등록된 글이 없습니다.</td>
						</tr>
					</c:when>

					<c:otherwise>
						<c:forEach var="item" items="${list}">
							<tr class="BoardTr" onclick = "NoticedetailPage(${item.boardNo})">
								<td class="td1">${item.boardNo}</td>
								<td class="td2">${item.title}</td>
								<td class="td3">${item.name}</td>
								<td class="td4">${item.onDate}</td>
								<td class="td5">${item.views}</td>
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
						<c:choose>
							<c:when test="${empty searchName}">
								<a href="#" class ="page-link">&laquo;</a>
							</c:when>
							<c:otherwise>
								<a href="NoticeSearchList.do?cpage=1&search=${searchName}" class ="page-link">&laquo;</a>
							</c:otherwise>
						</c:choose>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<c:choose>
							<c:when test="${empty searchName}">
								<a class="page-link" href="NoticeList.do?cpage=${pi.currentPage-1}">&laquo;</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="NoticeSearchList.do?cpage=${pi.currentPage-1}&search=${searchName}">&laquo;</a>
							</c:otherwise>
						</c:choose>
					</li>					
				</c:otherwise>
			</c:choose>
			
			<!-- 페이지 번호 -->
			<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
				<c:if test="${pi.currentPage == page}">
					<li class="page-item-active">
						<c:choose>
							<c:when test="${empty searchName}">
								<a class="page-link" href="/NoticeList.do?cpage=${page}">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="/NoticeSearchList.do?cpage=${page}&search=${searchName}">${page}</a>
							</c:otherwise>
						</c:choose>
					</li>
				</c:if>
				<c:if test="${pi.currentPage != page}">
					<li class="page-item">
						<c:choose>
							<c:when test="${empty searchName}">
								<a class="page-link" href="/NoticeList.do?cpage=${page}">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="/NoticeSearchList.do?cpage=${page}&search=${searchName}">${page}</a>
							</c:otherwise>
						</c:choose>
					</li>
				</c:if>
				
			</c:forEach>
			
			<!-- 페이지 처리 첫번째 >> 표시  -->
			<c:choose>
				<c:when test="${pi.currentPage == pi.maxPage}">
					<li class="page-item">
						<c:choose>
							<c:when test="${empty searchName}">
								<a class="page-link" href="#">&raquo;</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="/NoticeSearchList.do?cpage=1&search=${searchName}">&raquo;</a>
							</c:otherwise>
						</c:choose>
					</li>			
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<c:choose>
							<c:when test="${empty searchName}">
								<a class="page-link" href="/NoticeList.do?cpage=${pi.currentPage+1}">&raquo;</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="/NoticeSearchList.do?cpage=${pi.currentPage+1}&search=${searchName}">&raquo;</a>
							</c:otherwise>
						</c:choose>
					</li>			
				</c:otherwise>
			</c:choose>
		</ul>

	</section>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>