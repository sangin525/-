<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/MyPage.css">
<script src="/resources/js/member/member.js"></script>

</head>
<body class="Main_body">
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>

	<div class="main-container">
		<div class="container-center">
			<%@ include file="../../common/sidebar.jsp"%>

			<div class="contents">
				<div class="table-title">
					<h4>예약 내역</h4>
				</div>
				<br> <input type="hidden" name="cpage" value="1">
				<table class="mypage-table" id="content">
					<colgroup>
						<col width="13%" class="col1">
						<col class="col2">
					</colgroup>
					<thead class="mypage-thead">
						<tr>
							<td>예약번호</td>
							<td>인원수</td>
							<td>체크인</td>
							<td>체크아웃</td>
							<td>숙박일수</td>
							<td>예약자 이름</td>
							<td>객실번호</td>
						</tr>
					</thead>
					<tbody class="mypage-tbody" id="table-content">
						<c:choose>
							<c:when test="${empty list}">
								<tr>
									<td colspan="5" class="text-center">예약 내역이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="item" items="${list}">
									<tr onclick="detailPage(${item.r_no})">
										<td>${row}</td>
										<td>${item.per_no}</td>
										<td>${item.checkIn}</td>
										<td>${item.checkOut}</td>
										<td>${item.count}</td>
										<td>${item.m_name}</td>
										<td>${item.room_no}</td>
									</tr>
									<c:set var="row" value="${row-1}" />
								</c:forEach>
							</c:otherwise>
						</c:choose>

					</tbody>
				</table>
				<br>
				<br>

				<nav class="pageNav">
					<ul class="pagination">

						<c:choose>
							<c:when test="${pi.currentPage == 1}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:when>

							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="/MyReserve.do?cpage=${pi.currentPage-1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:otherwise>
						</c:choose>



						<!-- 1부터 10까지의 버튼 나열 -->
						<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
							<!-- if문을 작성해 현재 페이지가 pageNum과 동일하면 active 클래스가 추가된 리스트가 보여지도록 함 -->
							<c:if test="${pi.currentPage == page}">
								<li class="page-item-active"><a class="page-link"
									href="/MyReserve.do?cpage=${page}">${page} </a></li>
							</c:if>

							<!-- 현재 페이지와 pageNum이 동일하지 않은 9개의 버튼은 active가 활성화되지 않은 리스트가 보여지도록 함 -->
							<c:if test="${pi.currentPage != page}">
								<li class="page-item"><a class="page-link"
									href="/MyReserve.do?cpage=${page}">${page} </a></li>
							</c:if>
						</c:forEach>

						<c:choose>
							<c:when test="${pi.currentPage == pi.maxPage}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:when>

							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="/MyReserve.do?cpage=${pi.currentPage+1}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>

			</div>
		</div>
	</div>


	<%@ include file="../../common/footer.jsp"%>
</body>
</html>