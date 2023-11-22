<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../common/head.jsp"%>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>


<div class="container">
	<%@ include file="../../common/sidebar.jsp"%>
	
	<div class="contents">
	<div >
		<h4>문의 내역</h4>
	</div>
	<input type="hidden" name="cpage" value="1">
		<table class="table table-hover tableTypeA tableJoinForm tableUserInfo2" id="content">
		<colgroup>
			<col width="13%" class="col1">
			<col class="col2">
		</colgroup>
				<thead>
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
				<tbody class="table-group-divider" id="table-content">
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
	
	
		<%@ include file="../../common/footer.jsp"%>
</body>
</html>