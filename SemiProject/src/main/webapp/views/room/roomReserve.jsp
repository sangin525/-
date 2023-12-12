<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>

<script src="/resources/js/room/apikey.js"></script>

<script src="/resources/js/room/payments.js"></script>

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

		<h2 class="reserveForm"> 객실예약 페이지</h2>
		<div>
			<table class="mypage-table">
				<tbody class="mypage-tbody">
					<tr class="tr_info">
					<th>예약자 성함</th>
					<td>
						<p class="reserveForm" id="memberName">${member.MName}</p>
					</td>
					</tr>
					<tr class="tr_info">
					<th>예약자 번호</th>
					<td>
						<p class="reserveForm" id="memberPhone">${member.MPhone}</p>
							<span class="chkPhoneSpan">
								<input type="button" class="chkPhone" id="Chkbutton" onclick="phoneCertification(${member.MPhone});" value="인증메시지발송">
								<input type="text" class="chkPhone" id="chkPhoneNum" placeholder="인증번호를 입력해주세요" onkeyup="chkPhoneNum()" required>
								<p type="button" class="chkPhone" id="chkPhoneText"></p>
							</span>
					</td>
					</tr>
					<tr class="tr_info">
					<th>객실이름</th>
					<td>
						<p class="reserveForm" id="roomName">${room.roomName} 룸</p>
					</td>
					</tr>
					<tr class="tr_info">
					<th>숙박체크인</th>
					<td>
						<c:if test="${startDayWeekNumber == 7}">
							<p class="reserveForm">${room.RChkIn} 토요일</p>
						</c:if>
						<c:if test="${startDayWeekNumber == 6}">
							<p class="reserveForm">${room.RChkIn} 금요일</p>
						</c:if>
						<c:if test="${startDayWeekNumber == 5}">
							<p class="reserveForm">${room.RChkIn} 목요일</p>
						</c:if>
						<c:if test="${startDayWeekNumber == 4}">
							<p class="reserveForm">${room.RChkIn} 수요일</p>
						</c:if>
						<c:if test="${startDayWeekNumber == 3}">
							<p class="reserveForm">${room.RChkIn} 화요일</p>
						</c:if>
						<c:if test="${startDayWeekNumber == 2}">
							<p class="reserveForm">${room.RChkIn} 월요일</p>
						</c:if>
						<c:if test="${startDayWeekNumber == 1}">
							<p class="reserveForm">${room.RChkIn} 일요일</p>
						</c:if>
					</td>
					</tr>
					<tr class="tr_info">
					<th>숙박체크아웃</th>
					<td>
						<c:if test="${endDayWeekNumber == 7}">
							<p class="reserveForm">${room.RChkOut} 토요일</p>
						</c:if>
						<c:if test="${endDayWeekNumber == 6}">
							<p class="reserveForm">${room.RChkOut} 금요일</p>
						</c:if>
						<c:if test="${endDayWeekNumber == 5}">
							<p class="reserveForm">${room.RChkOut} 목요일</p>
						</c:if>
						<c:if test="${endDayWeekNumber == 4}">
							<p class="reserveForm">${room.RChkOut} 수요일</p>
						</c:if>
						<c:if test="${endDayWeekNumber == 3}">
							<p class="reserveForm">${room.RChkOut} 화요일</p>
						</c:if>
						<c:if test="${endDayWeekNumber == 2}">
							<p class="reserveForm">${room.RChkOut} 월요일</p>
						</c:if>
						<c:if test="${endDayWeekNumber == 1}">
							<p class="reserveForm">${room.RChkOut} 일요일</p>
						</c:if>
					</td>
					</tr>	
					<tr class="tr_info">
					<th>숙박일수</th>
					<td>
						<p class="reserveForm" id="roomCount">${room.RCount} 일</p>
					</td>
					</tr>
					<tr class="tr_info">	
					<th>숙박인원수</th>
					<td>
						<p class="reserveForm" id="RPersonCount">${room.RPersonCount} 명</p>
					</td>
					</tr>	
					<tr class="tr_info">	
					<th>숙박인원수</th>
					<td>
						<c:set var="totalPrice"  value="0"></c:set>
							<c:if test="${startDayWeekNumber >= 6}">
								<c:set var="totalPrice" value="${totalWeekend * room.RCount}"></c:set>
							</c:if>
							<c:if test="${startDayWeekNumber < 6}">
								<c:set var="totalPrice" value="${totalWeekday * room.RCount}"></c:set>
							</c:if>
						<p class="reserveForm"> <input type="checkbox" id="MLGChk" onchange="addMLGChk(${totalPrice},${member.MLG}, ${percentMLG}, '${member.membership}')"> 마일리지 전액사용 </p>
						<div class="reserveForm" id="addMoneyDiv">사용할 마일리지 금액
							<input type="number" id="addMoneyMLG" value="0" disabled><br>
							<c:set var="one" value="one"></c:set>
							<c:set var="two" value="two"></c:set>
							<c:set var="three" value="three"></c:set>
							<c:set var="four" value="four"></c:set>
							<c:set var="reset" value="reset"></c:set>
							<button class="addMoneyBtn" value="1000" id="oneAdd" onclick="addMLGMoney('${one}',${totalPrice},${member.MLG}, ${percentMLG}, '${member.membership}')">천원추가</button>
							<button class="addMoneyBtn" value="10000" id="twoAdd" onclick="addMLGMoney('${two}',${totalPrice},${member.MLG}, ${percentMLG}, '${member.membership}')">만원추가</button>
							<button class="addMoneyBtn" value="50000" id="threeAdd" onclick="addMLGMoney('${three}',${totalPrice},${member.MLG}, ${percentMLG}, '${member.membership}')">오만원추가</button>
							<button class="addMoneyBtn" value="100000" id="fourAdd" onclick="addMLGMoney('${four}',${totalPrice},${member.MLG}, ${percentMLG}, '${member.membership}')">십만원추가</button>
							<button class="addMoneyBtn" id="resetAdd" onclick="addMLGMoney('${reset}',${totalPrice},${member.MLG}, ${percentMLG}, '${member.membership}')">초기화</button>
						</div>
					</td>
					</tr>	
					<tr class="tr_info">	
					<th>결제금액</th>
					<td>
						<p class="reserveForm" id="totalPrice">${totalPrice} 원</p>
					</td>
					</tr>	
					<tr class="tr_info">	
					<th>현재 마일리지</th>
					<td>
						<p class="reserveForm" id="memberMLG">${member.MLG} 원</p>
					</td>
					</tr>	
					<tr class="tr_info">	
					<th>적립 마일리지</th>
					<td>
						<p class="reserveForm" id="addMLG">${(totalPrice * percentMLG)-((totalPrice * percentMLG)%1)} 원 (고객님은 ${member.membership} 등급으로 결제금액의 ${percentMLG}% 입니다.)</p>
					</td>
					</tr>	
					<tr class="tr_info">	
					<th>누적결제금액</th>
					<td>
						<p class="reserveForm" id="accamount">${member.accamount}</p>
					</td>
					</tr>	
					<tr class="tr_info">	
					<th>누적결제금액에 따른 등급</th>
					<td>
						<p class="reserveForm">0 bronze 100 Silver 500 Gold 1000 Platinum 5000 Black (단위 : 만원 /이상/미만)</p>
					</td>
					</tr>	
					
				</tbody>
			</table>
		
		</div>
		<br>
		<div class="reserve-btn">
	<button type="button" class="payForm" id="left-btn" onclick="requestPay(${member.MLG}, '${member.MName}',
								 '${room.roomName}', ${totalPrice}, '${member.MPhone}',

								  '${member.MEmail}', '${member.MAddr}', '${room.RChkIn}',
								  '${room.RChkOut}', ${room.RPersonCount}, ${room.RCount}, ${percentMLG})" disabled>(결제)인증번호 입력후 눌러주세요</button>
	<button type="button" class="payForm" id="Write-btn" onclick="intoInfoPage()">방구경하러가기</button>
		</div>








</section>

<%@ include file="../common/footer.jsp" %>
</body>
</html>