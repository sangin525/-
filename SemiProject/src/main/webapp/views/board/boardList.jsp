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
<body class="boardBody">
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
				<button class="right-btn-board-Enroll" onclick="boardEnrollBtn()"> <img class="btnStyle" src="/resources/boardIcon/file-earmark-plus.svg"> 글 쓰기</button>				
				<input type="hidden" id="test" value="${sessionScope.no}">
			</div>
		</div>
		
		<div class="divSort3">
			<input class="divSort3Input" placeholder ="검색어를 입력해주세요" id="searchBtn" onkeypress ="if(window.event.keyCode==13){search()}">
			<button onclick ="search()">검색</button>
		</div>
		
		<!-- 버튼 모음 -->
		<c:set var="selectedCategory" value="${param.category}" />
		<div class="divSort2">
			<button class="SortBtn" name="category" value="전체" onclick="clickCategory(event);"
			style="background-color: ${'전체' eq selectedCategory ? 'rgb(224, 162, 86)' : 'white'};
	        color: ${'전체' eq selectedCategory ? 'white' : 'gray'};">전체</button>
			<button class="SortBtn" name="category" value="객실 문의" onclick="clickCategory(event);"
			style="background-color: ${'객실 문의' eq selectedCategory ? 'rgb(224, 162, 86)' : 'white'};
	        color: ${'객실 문의' eq selectedCategory ? 'white' : 'gray'};">객실 문의</button>
			<button class="SortBtn" name="category" value="예약 문의" onclick="clickCategory(event);"
			style="background-color: ${'예약 문의' eq selectedCategory ? 'rgb(224, 162, 86)' : 'white'};
	        color: ${'예약 문의' eq selectedCategory ? 'white' : 'gray'};">예약 문의</button>
			<button class="SortBtn" name="category" value="시설 문의" onclick="clickCategory(event);"
			style="background-color: ${'시설 문의' eq selectedCategory ? 'rgb(224, 162, 86)' : 'white'};
	        color: ${'시설 문의' eq selectedCategory ? 'white' : 'gray'};">시설 문의</button>
			<button class="SortBtn" name="category" value="회원가입 및 로그인 문의" onclick="clickCategory(event);"
			style="background-color: ${'회원가입 및 로그인 문의' eq selectedCategory ? 'rgb(224, 162, 86)' : 'white'};
	        color: ${'회원가입 및 로그인 문의' eq selectedCategory ? 'white' : 'gray'};">회원 가입 및 로그인 문의</button>
			<button class="SortBtn" name="category" value="기타 문의" onclick="clickCategory(event);"
			style="background-color: ${'기타 문의' eq selectedCategory ? 'rgb(224, 162, 86)' : 'white'};
	        color: ${'기타 문의' eq selectedCategory ? 'white' : 'gray'};">기타 문의</button>
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
				<th class="th6">비밀글</th>
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
						
							<tr class="BoardTr" onclick = "detailPage(${item.boardNo}, '${item.secret}')">
								<input type="hidden" value="${item.m_No}" id="m_No">
								<input type="hidden" value="${sessionScope.no}" id="session_No">
								<input type="hidden" value="${sessionScope.admin}" id="session_admin">
								
								<td class="td1">${item.boardNo}</td>
								<td class="td2">${item.title}</td>
								<td class="td3">${item.name}</td>
								<td class="td4">${item.onDate}</td>
								<td class="td5">${item.views}</td>
								<td class="td6">${item.answer}</td>
								<!-- 비밀글 여부 -->
								<c:choose>
									<c:when test="${item.secret != null}">
										<td class="td6"><img src="/resources/boardIcon/lock-fill.svg"></td>
									</c:when>
									<c:otherwise>
										<td class="td6">-</td>
									</c:otherwise>
								</c:choose>
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
						<c:choose>
							<c:when test="${empty searchName && category != '전체'}">
								<a class="page-link" href="BoardCategoryList.do?cpage=${pi.currentPage-1}&category=${category}">&laquo;</a>
							</c:when>
							<c:when test="${empty searchName && category == '전체'}">
								<a class="page-link" href="BoardList.do?cpage=${pi.currentPage-1}&category=전체">&laquo;</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="BoardSearchList.do?cpage=${pi.currentPage-1}&search=${searchName}">&laquo;</a>
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
							<c:when test ="${empty searchName && category != '전체'}">
								<a class="page-link" href="/BoardCategoryList.do?cpage=${page}&category=${category}">${page}</a>
							</c:when>
							<c:when test="${empty searchName && category == '전체'}">
								<a class="page-link" href="BoardList.do?cpage=${page}&category=전체">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="/BoardSearchList.do?cpage=${page}&search=${searchName}">${page}</a>
							</c:otherwise>
						</c:choose>
					</li>
				</c:if>
				<c:if test="${pi.currentPage != page}">
					<li class="page-item">
						<c:choose>
							<c:when test="${empty searchName && category != '전체'}">
								<a class="page-link" href="/BoardCategoryList.do?cpage=${page}&category=${category}">${page}</a>
							</c:when>
							<c:when test="${empty searchName && category == '전체'}">
								<a class="page-link" href="BoardList.do?cpage=${page}&category=전체">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="/BoardSearchList.do?cpage=${page}&search=${searchName}">${page}</a>							
							</c:otherwise>
						</c:choose>
					</li>
				</c:if>
			</c:forEach>
			
			<!-- 페이지 처리 첫번째 >> 표시  -->
			<c:choose>
				<c:when test="${pi.currentPage == pi.maxPage}">
					<li class="page-item">
						<a class="page-link" href="#">&raquo;</a>
					</li>			
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<c:choose>
							<c:when test="${empty searchName && category != '전체'}">
								<a class="page-link" href="/BoardCategoryList.do?cpage=${pi.currentPage+1}&category=${category}">&raquo;</a>
							</c:when>
							<c:when test="${empty searchName && category == '전체'}">
								<a class="page-link" href="BoardList.do?cpage=${pi.currentPage+1}&category=전체">&raquo;</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="/BoardSearchList.do?cpage=${pi.currentPage+1}&search=${searchName}">&raquo;</a>
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