<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제내역</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<%@ include file="../common/head.jsp" %>
<link href="/resources/css/room/reserveBasket.css" rel="stylesheet" type="text/css">
</head>
<body>
<script src="/resources/js/room/food.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
   <%@ include file="../common/header.jsp" %>
   <%@ include file="../common/nav.jsp" %>
<table class="table table-hover" style="margin-left: 35px">
<br><br>
<h3 class="basketH3Tag"> 결제내역 입니다.</h3>
  <thead>
    <tr>
      <th scope="col">결제번호</th>
      <th scope="col">회원이름</th>
      <th scope="col">상품이름</th>
      <th scope="col">주문수량</th>
      <th scope="col">상품가격</th>
      <th scope="col">상품분류</th>
      <th scope="col">결제방식</th>
    </tr>
  </thead>
  <tbody>
  
  <c:choose>
  	<c:when test="${empty itemPayList}">
  		<tr>
  			<th></th>
  			<td>결제항목이 비어있습니다.</td>
  			<td></td>
  			<td></td>
  			<td>결제항목이 비어있습니다.</td>
  			<td></td>
  			<td></td>
  		</tr>
  	</c:when>
  	<c:otherwise>
	  <c:forEach var="item" items="${itemPayList}">
		<c:set var="count" value="${count+1}"></c:set>
	    <tr>
	      <th scope="row">${count}</th>
	      <td>${item.MName}</td>
	      <td id="foodName${count}" onclick="foodNameClick(${count})" style="cursor:pointer">${item.foodName}</td>
	      <td>${item.foodCount}</td>
	      <td>${item.foodPrice}</td>
	      <td>${item.foodTime}</td>
	      <td>${item.itemPayWay}</td>
	    </tr>
	  </c:forEach>
  	</c:otherwise>
  </c:choose>
  </tbody>
</table>
<br><br>
<div id="basketBtnDiv">
<button class="btn btn-outline-danger" onclick="pageChangeBack()">상품페이지이동</button>
<button class="btn btn-outline-danger" onclick="pageChangeBasket()">장바구니로이동</button>
</div>
<br><br>
<%@ include file="../common/footer.jsp" %>
</body>
</html>