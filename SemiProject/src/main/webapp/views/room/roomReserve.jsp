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
		<p class="reserveForm">예약자 성함 :  </p>
		<p class="reserveForm">객실이름 :  ${room.roomName} 룸</p>
		<p class="reserveForm">숙박체크인 : ${room.RChkIn} 일</p>
		<p class="reserveForm">숙박체크아웃 : ${room.RChkOut} 일</p>
		<p class="reserveForm">숙박일수 : ${room.RCount} 일</p>
		<p class="reserveForm">숙박인원수 : ${room.RPersonCount} 명</p>
		<p class="reserveForm">결제금액 :  </p>
		<p class="reserveForm">현재 마일리지 :</p>
		<p class="reserveForm">적립후 마일리지 :</p>
		
		</div>
		
	<button type="submit" class="payForm">결제하기</button>
	<button type="button" class="payForm">방구경하러가기</button>
	</form>







</section>

<%@ include file="../common/footer.jsp" %>
</body>
</html>