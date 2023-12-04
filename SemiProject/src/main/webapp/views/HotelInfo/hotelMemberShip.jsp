<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/resources/css/hotelInfo/hotelInfo.css">
    <link rel="stylesheet" href="/resources/css/hotelInfo/membership.css">
  <meta charset="UTF-8">
  <%@ include file="../common/head.jsp"%>


</head>
<body class="Main_body">
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	
	  <div class="contain">
    <div class="container">

	<%@ include file="../common/hotelInfoSidebar.jsp" %>
	<div class="membership">
	<div class="membership-title">
	<h2>CLUB HARU</h2>
	<p>클럽하루 멤버십은 품격있는 라이프 스타일과 특별한 경험을 제안합니다.</p>
	<p>호텔하루에서 다채로운 혜택과 최상의 서비스를 누려보세요.</p>
	</div>
	<br><br>
	<div class="membership-reward">
	<h3>CLUB HARU REWARDS</h3>
	<p>클럽하루 리워드는 회원가입과 동시에 포인트 적립혜택을 제공해 드리고 있습니다.</p>
	</div>
	
	<div class="reward-title">
		<div class="reward-content">
			<h4>POINT</h4>
			<p>레스토랑 이용시 1% 포인트 적립</p>
			<p>숙박 이용시 1% 포인트 적립</p>
			<p>1,000점 이상부터 사용 가능</p>
		</div>
		<div class="reward-content">
			<h4>BENEFIT</h4>
			<p>웰컴 드링크 2잔</p>
			<p>레스토랑 10% 할인</p>
		</div>
		<div class="reward-content">
			<button onclick="location.href='/ChkForm.do'" class="left-btn">회원가입</button>
		</div>
	</div>
	<br><br>
	<div>
	<h3>CLUB HARU VIP</h3>
	<p>클럽하루 VIP는 트별한 당신께 호텔하루의 격조 높은 서비스와 다양한 바우처 혜택을 제공하는 고품격 멤버십입니다.</p>
	</div>

		<div class="membershipBox">
			<div class="membershipCard">
				<span><img src="/resources/uploads/membership/silver.png"></span>
				<p>Silver</p>
				<p>누적 숙박 금액</p>
				<p>1,000,000원 이상</p>
				<ul>
					<li>레스토랑 이용시 1.5% 포인트 적립</li>
					<li>숙박 이용시 3% 포인트 적립</li>
					<li>Laundry 10% 할인</li>
					<li>조식 10% 할인</li>
				</ul>
			</div>
			<div class="membershipCard">
			<span><img src="/resources/uploads/membership/gold.png"></span>
				<p>Gold</p>
				<p>누적 숙박 금액</p>
				<p>5,000,000원 이상</p>
				<ul>
					<li>레스토랑 이용시 2% 포인트 적립</li>
					<li>숙박 이용시 5% 포인트 적립</li>
					<li>Laundry 20% 할인</li>
					<li>조식 20% 할인</li>
					<li>스파 50% 할인</li>
					<li>수영장 50% 할인</li>
					<li>발렛파킹 서비스 이용권 연 6회</li>
				</ul>
			</div>
			<div class="membershipCard">
			<span><img src="/resources/uploads/membership/platinum.png"></span>
				<p>Platinum</p>
				<p>누적 숙박 금액</p>
				<p>10,000,000원 이상</p>
				<ul>
					<li>레스토랑 이용시 3% 포인트 적립</li>
					<li>숙박 이용시 7% 포인트 적립</li>
					<li>Laundry 무료 제공</li>
					<li>조식 50% 할인</li>
					<li>스파 무료 이용권</li>
					<li>수영장 무료 이용권</li>
					<li>발렛파킹 서비스 이용권 연 12회</li>
					<li>Wine Corkage Free 이용권 2회</li>
					<li>객실 업그레이드 (스위트 제외)</li>
					<li>클럽라운지 동반 1인 무료</li>
					<li>Early Check-In</li>
					<li>Late Check-Out</li>
				</ul>
			</div>
			<div class="membershipCard">
			<span><img src="/resources/uploads/membership/black.png"></span>
				<p>Black</p>
				<p>누적 숙박 금액</p>
				<p>50,000,000원 이상</p>
				<ul>
					<li>레스토랑 이용시 5% 포인트 적립</li>
					<li>숙박 이용시 10% 포인트 적립</li>
					<li>Laundry 무료 제공</li>
					<li>조식 무료 제공</li>
					<li>스파 무료 이용권</li>
					<li>수영장 무료 이용권</li>
					<li>발렛파킹 서비스 이용권 연 24회</li>
					<li>Wine Corkage Free 이용권 5회</li>
					<li>객실 업그레이드 (스위트 제외)</li>
					<li>클럽라운지 동반 1인 무료</li>
					<li>클럽라운지 1인 무료 이용권</li>
					<li>Early Check-In</li>
					<li>Late Check-Out</li>
					<li>무료 숙박권</li>
					<li>초과 숙박금액 이월</li>
				</ul>
			</div>
		</div>
	</div>
		
    </div>
  </div>
	</div>

	<%@ include file="../common/footer.jsp"%>
</body>
</html>