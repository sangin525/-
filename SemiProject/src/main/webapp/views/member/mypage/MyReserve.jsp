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
	<br>
	<input type="hidden" name="cpage" value="1">
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
	</div>
	</div>
</div>
	
	
		<%@ include file="../../common/footer.jsp"%>
</body>
</html>