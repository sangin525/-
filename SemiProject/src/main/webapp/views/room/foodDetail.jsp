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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<link href="/resources/css/room/roomShop.css" rel="stylesheet" type="text/css">
<link href="/resources/css/room/foodDetail.css" rel="stylesheet" type="text/css">

<script src="/resources/js/room/apikey.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>

</head>
<body>
<script src="/resources/js/room/food.js"></script>
<script src="/resources/js/room/payments.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
   <%@ include file="../common/header.jsp" %>
   <%@ include file="../common/nav.jsp" %>
<section class="Main_section" id="section_main">
<div id="carouselExampleIndicators" class="carousel slide">
            <div class="carousel-indicators">
               <button type="button" data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="0" class="active" aria-current="true"
                  aria-label="Slide 1"></button>
               <button type="button" data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="1" aria-label="Slide 2"></button>
               <button type="button" data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
               <div class="carousel-item active">
                  <img src="${food.foodPhoto1}" class="d-block w-100" alt="식당사진">
               </div>
               <div class="carousel-item">
                  <img src="${food.foodPhoto2}" class="d-block w-100" alt="식당사진">
               </div>
               <div class="carousel-item">
                  <img src="${food.foodPhoto3}" class="d-block w-100" alt="식당사진">
               </div>
            </div>
            <button class="carousel-control-prev" type="button"
               data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
               <span class="carousel-control-prev-icon" aria-hidden="true"></span>
               <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button"
               data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
               <span class="carousel-control-next-icon" aria-hidden="true"></span>
               <span class="visually-hidden">Next</span>
            </button>
         </div>
         <div class="foodDetailDiv">
         	<span>[하루호텔]</span>
         	<h1>12월 상품 [${food.foodName}]</h1><br>
	         <div>
         		<dl>
         			<dt class="foodDetailDl">판매가</dt>
	       				<dd class="foodDetailDl">
	       					<div class="foodDetailDl">KRW  <span id="foodPriceOne">${food.foodPrice}</span></div>
	       				</dd><br><br>
       				<dt class="foodDetailDl">사용가능한쿠폰</dt>
       					<dd class="foodDetailDl">
	       					<select id="foodDetailCoupon">
								<option>--쿠폰--</option>	       					
								<option>--쿠폰--ssssssssssssssssssssss</option>	       					
	       					</select>
       					 </dd><br><br>
       				<dt class="foodDetailDl">상품구매수량</dt>
       					<dd class="foodDetailDl"><input type="number" id="foodDeailCount" onchange="sumFoodPrice(${food.foodPrice})"  value="1"></dd><br>
       				<dt class="foodDetailDl">총 상품금액</dt>
       					<dd class="foodDetailDl">KRW  <span id="foodDetailPrice">${food.foodPrice}</span></dd><br>
         		<button class="btn btn-outline-primary" onclick="basketListEnroll('${food.foodName}', ${food.foodPrice}, '${food.foodTime}')">장바구니담기</button>
         		<button class="btn btn-outline-primary" onclick="oneItemPay('${food.foodName}', ${food.foodPrice}, '${food.foodTime}')">결제하기</button>
         		</dl>
	         </div>
         </div>
         <div>asdasdasd</div>
		<hr style="border: solid 1px black;">
		
		<div>
			<dl>
				<dt class="foodDetailInfo" >상품설명</dt>
				<dd>${food.standardMenu}</dd>
			</dl>
		</div><br>
		<div id="imgChooseDiv">
			<c:choose>
				<c:when test="${food.foodTime == '굿즈'}"><img alt="" src="/resources/uploads/room/내용.jpg"></c:when>
				<c:when test="${food.foodTime == '시즌상품'}"><img alt="" src="/resources/uploads/room/내용3.jpg"></c:when>
				<c:when test="${food.foodTime == '침구류'}"><img alt="" src="/resources/uploads/room/내용2.jpg"></c:when>
				<c:when test="${food.foodTime == '식사'}"><img alt="" src="/resources/uploads/room/내용4.jpg"></c:when>
				<c:when test="${food.foodTime == '커피'}"><img alt="" src="/resources/uploads/room/내용5.jpg"></c:when>
				<c:when test="${food.foodTime == '투고'}"><img alt="" src="/resources/uploads/room/내용7.jpg"></c:when>
			</c:choose>
		</div>
		<div>
			<a href="http://pf.kakao.com/_PNxjXG" class="btn_kakao" style="display:none;">
			  <img src="/resources/uploads/mainPic/카카오로고.png" style="width:65px; height:70px">
			  </a>
			<a href="#" class="btn_gotop" style="display:none;">
			  <img src="/resources/uploads/mainPic/위로버튼.png" style="width:100px; height:100px">
			</a>
		</div>


 <br><br><br><br><br><br>
</section>

<%@ include file="../common/footer.jsp" %>
</body>
</html>