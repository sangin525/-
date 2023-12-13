<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/head.jsp" %>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link href="/resources/css/room/roomShop.css" rel="stylesheet" type="text/css">
<link href="/resources/css/room/foodInfo.css" rel="stylesheet" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="Main_body">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/room/food.js"></script>
   <%@ include file="../common/header.jsp" %>
   <%@ include file="../common/nav.jsp" %>
<section class="Main_section" id="section_main">
<!-- <select id="optionSelect" onchange="optionValue()"> -->
	<button class="btn btn-outline-success" value="전체" onclick="optionValue(event)">--전체보기--</button>
	<button class="btn btn-outline-success" value="식사" onclick="optionValue(event)">식사권</button>
	<button class="btn btn-outline-success" value="침구류" onclick="optionValue(event)">침구류</button>
	<button class="btn btn-outline-success" value="굿즈" onclick="optionValue(event)">굿즈</button>
	<button class="btn btn-outline-success" value="시즌상품" onclick="optionValue(event)">시즌상품</button>
<!-- </select><br> -->
<button class="btn btn-outline-danger" id="basketMoveBtn" value="장바구니" onclick="movePagePay(event)">장바구니로 이동</button>
<button class="btn btn-outline-danger" id="payBasketMoveBtn" value="상품결제내역" onclick="movePagePay(event)">상품결제내역으로 이동</button>
<h3>상품내용</h3>
<c:choose>
	<c:when test="${!empty itemList}">
		<c:forEach var="item" items="${itemList}">
		
			<c:set var="count" value="${count+1}"></c:set>
		<div id="foodInfoDiv">
			<ul id="foodInfoUl">
				<li> 
					<div id="pageChange" onclick="foodDetail('${item.foodName}')">
						<img alt="" src="${item.foodPhoto1}" id="foodInfoImg">
						<p><em>[하루호텔]</em></p>
						<p>상품이름 : ${item.foodName}</p>
						<p>상품정보 : ${item.foodInfo}</p>
					</div>
					<hr>
					<div>
						<p>상품가격 : <em>KRW</em> : ${item.foodPrice} </p>
					</div>
				</li>
			</ul>
		</div>
		
		</c:forEach>
	</c:when>
	
	<c:otherwise>
		<c:forEach var="item" items="${food}">
		
			<c:set var="count" value="${count+1}"></c:set>
		<div id="foodInfoDiv">
			<ul id="foodInfoUl">
				<li> 
					<div id="pageChange" onclick="foodDetail('${item.foodName}')">
						<img alt="" src="${item.foodPhoto1}" id="foodInfoImg">
						<p><em>[하루호텔]</em></p>
						<p>상품이름 : ${item.foodName}</p>
						<p>상품정보 : ${item.foodInfo}</p>
					</div>
					<hr>
					<div>
						<p>상품가격 : <em>KRW</em> : ${item.foodPrice} </p>
					</div>
				</li>
			</ul>
		</div>
		
		</c:forEach>
	
	</c:otherwise>
</c:choose>
 
<div>
	<a href="http://pf.kakao.com/_PNxjXG" class="btn_kakao" style="display:none;">
	  <img src="/resources/uploads/mainPic/카카오로고.png" style="width:65px; height:70px">
	  </a>
	<a href="#" class="btn_gotop" style="display:none;">
	  <img src="/resources/uploads/mainPic/위로버튼.png" style="width:100px; height:100px">
	</a>
</div>



 <br><br><br><br><br><br><br><br>
 <br><br><br><br><br><br><br><br>
 <br><br><br><br><br><br><br><br>
 <br><br><br><br><br><br>
</section>  


<%@ include file="../common/footer.jsp" %>
</body>
</html>