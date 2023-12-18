<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<%@ include file="../common/head.jsp" %>

<link href="/resources/css/room/reserveBasket.css" rel="stylesheet" type="text/css">
<script src="/resources/js/room/apikey.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
</head>
<body>
<script src="/resources/js/room/food.js"></script>
<script src="/resources/js/room/payments.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
   <%@ include file="../common/header.jsp" %>
   <%@ include file="../common/nav.jsp" %>
<table class="table table-hover" style="margin-left: 35px">
<br><br>
<h3 class="basketH3Tag"> 장바구니 입니다.</h3>
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">상품이름</th>
      <th scope="col">주문수량</th>
      <th scope="col">상품가격</th>
      <th scope="col">상품분류</th>
      <th scope="col">선택하기</th>
    </tr>
  </thead>
  <tbody>
  
  <c:choose>
  	<c:when test="${empty basketList}">
  		<tr>
  			<th></th>
  			<td>장바구니가 비어있습니다.</td>
  			<td></td>
  			<td>장바구니가 비어있습니다.</td>
  			<td></td>
  		</tr>
  	</c:when>
  	<c:otherwise>
	  <c:forEach var="item" items="${basketList}">
		<c:set var="count" value="${count+1}"></c:set>
	      <input type="hidden" class="hiddenBasketNo" id="hiddenBasketNo${count}" value= "${item.foodBasketNo}">
	    <tr>
	      <th scope="row">${count}</th>
	      <td value="${item.foodName}" id="foodName${count}" onclick="foodNameClick(${count})" style="cursor:pointer">${item.foodName}</td>
	      <td value="${item.foodCount}">${item.foodCount}</td>
	      <td class="foodPrice" id="foodPrice${count}" >${item.foodPrice}</td>
	      <td value="${item.foodTime}">${item.foodTime}</td>
	      <td><input type="checkbox" class="basketListChk" id="basketListChk${count}" onchange="getTotalPrice(event, ${count}, ${percentMLG}); itemChkList(event, ${count})">결제할상품체크</td>
	      <td><input type="button" class="btn btn-outline-primary" value="상품삭제" onclick="deleteItem(${item.foodBasketNo})"></td>
	    </tr>
	  </c:forEach>
  	</c:otherwise>
  </c:choose>
  </tbody>
</table>
<div id="basketBtnDiv">
<input type="checkbox" id="allChkBtn" onchange=" itemAllChkList(event); allChkBtn(event, ${count}, ${percentMLG})">전체선택/전체해제  <br><br>
 <span>결제금액 :</span>
<input type="text" id="basketTotalPrice" value="0" disabled>
<p>회원님의 등급은 : ${basketGrade.membership} 으로 적립마일리지는 <input type="number" id="basketMLG" style="width:85px; height:20px" value="0" disabled > 원 입니다</p>
<button class="btn btn-outline-danger" onclick="itemRequestPay()">결제하기</button>
<button class="btn btn-outline-danger" onclick="pageChangeBack()">상품페이지이동</button>
</div>

<br><br>
<%@ include file="../common/footer.jsp" %>
</body>
</html>