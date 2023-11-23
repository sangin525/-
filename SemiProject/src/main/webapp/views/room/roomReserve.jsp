<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%@ include file="../common/head.jsp" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="/resources/css/room/roomReserve.css" rel="stylesheet" type="text/css">


</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/nav.jsp" %>
<script src="/resources/js/room/room.js"></script>
<section class="Main_section">

	<form action="" method="POST">
		<h2 class="reserveForm"> 객실예약 페이지</h2>
		<div>
		<p class="reserveForm">예약자 성함 :  ${sessionScope.name}</p>
		<p class="reserveForm">객실이름 :  ${room.roomName} 룸</p>
		<c:if test="${startDayWeekNumber == 7}">
			<p class="reserveForm">숙박체크인 : ${room.RChkIn} 토요일</p>
		</c:if>
		<c:if test="${startDayWeekNumber == 6}">
			<p class="reserveForm">숙박체크인 : ${room.RChkIn} 금요일</p>
		</c:if>
		<c:if test="${startDayWeekNumber == 5}">
			<p class="reserveForm">숙박체크인 : ${room.RChkIn} 목요일</p>
		</c:if>
		<c:if test="${startDayWeekNumber == 4}">
			<p class="reserveForm">숙박체크인 : ${room.RChkIn} 수요일</p>
		</c:if>
		<c:if test="${startDayWeekNumber == 3}">
			<p class="reserveForm">숙박체크인 : ${room.RChkIn} 화요일</p>
		</c:if>
		<c:if test="${startDayWeekNumber == 2}">
			<p class="reserveForm">숙박체크인 : ${room.RChkIn} 월요일</p>
		</c:if>
		<c:if test="${startDayWeekNumber == 1}">
			<p class="reserveForm">숙박체크인 : ${room.RChkIn} 일요일</p>
		</c:if>
		
		
		<c:if test="${endDayWeekNumber == 7}">
			<p class="reserveForm">숙박체크아웃 : ${room.RChkOut} 토요일</p>
		</c:if>
		<c:if test="${endDayWeekNumber == 6}">
			<p class="reserveForm">숙박체크아웃 : ${room.RChkOut} 금요일</p>
		</c:if>
		<c:if test="${endDayWeekNumber == 5}">
			<p class="reserveForm">숙박체크아웃 : ${room.RChkOut} 목요일</p>
		</c:if>
		<c:if test="${endDayWeekNumber == 4}">
			<p class="reserveForm">숙박체크아웃 : ${room.RChkOut} 수요일</p>
		</c:if>
		<c:if test="${endDayWeekNumber == 3}">
			<p class="reserveForm">숙박체크아웃 : ${room.RChkOut} 화요일</p>
		</c:if>
		<c:if test="${endDayWeekNumber == 2}">
			<p class="reserveForm">숙박체크아웃 : ${room.RChkOut} 월요일</p>
		</c:if>
		<c:if test="${endDayWeekNumber == 1}">
			<p class="reserveForm">숙박체크아웃 : ${room.RChkOut} 일요일</p>
		</c:if>
		
		<p class="reserveForm">숙박일수 : ${room.RCount} 일</p>
		<p class="reserveForm">숙박인원수 : ${room.RPersonCount} 명</p>
		<c:set var="totalPrice" value="0"></c:set>
			<c:if test="${startDayWeekNumber >= 6}">
				<c:set var="totalPrice" value="${totalWeekend * room.RCount}"></c:set>
			</c:if>
			<c:if test="${startDayWeekNumber < 6}">
				<c:set var="totalPrice" value="${totalWeekday * room.RCount}"></c:set>
			</c:if>
			
		<p class="reserveForm">결제금액 :  ${totalPrice} 원</p>
		<p class="reserveForm">현재 마일리지 : ${memberMLG.MLG} 원</p>
		<p class="reserveForm">적립 마일리지 : ${totalPrice *0.05} 원 (결제금액의 5%)</p>
		</div>
		
	<button type="submit" class="payForm">결제하기</button>
	<button type="button" class="payForm">방구경하러가기</button>
	</form>







</section>

<%@ include file="../common/footer.jsp" %>
</body>
</html>