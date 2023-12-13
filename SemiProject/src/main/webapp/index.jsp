<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String name = (String)session.getAttribute("name");
%>
<!DOCTYPE html>
<html>

<head>
   <%@ include file="./views/common/head.jsp" %>

   <link rel="stylesheet" href="/resources/css/member/MyPage.css">
  <script src="/resources/js/common/slideImg.js"></script>
  <script src="/resources/js/common/popup.js"></script>


</head>
  
<body class="Main_body">
<div class="main-container">
   <%@ include file="./views/common/header.jsp" %>
   <%@ include file="./views/common/nav.jsp" %>
   
   
<div class="img-div">
<img class="change-image"></img>

<h1 class="text-image1">Welcome to HotelHaru</h1>
<h1 class="text-image2">호텔 하루를 찾아주셔서 감사합니다.</h1>


</div>
</div>

<br>
<%@ include file="./views/common/section.jsp" %>
<%@ include file="./views/common/popup.jsp" %>

  
<br>

   <%@ include file="./views/common/footer.jsp" %>
   
<div>
<a href="http://pf.kakao.com/_PNxjXG" class="btn_kakao" style="display:none;">
  <img src="/resources/uploads/mainPic/카카오로고.png" style="width:65px; height:70px">
  </a>
<a href="#" class="btn_gotop" style="display:none;">
  <img src="/resources/uploads/mainPic/위로버튼.png" style="width:100px; height:100px">
</a>
</div>


</body>
</html>