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


</head>
  
<body class="Main_body">
<div class="main-container">
   <%@ include file="./views/common/header.jsp" %>
   <%@ include file="./views/common/nav.jsp" %>
   
<div class="img-div">
<img class="change-image"></img>
</div>


  <section class="Main_section">
  	<h2><strong>호텔 주변 명소</strong></h2>
  	<hr>
  	<br>

  	<div class="traditional">
  	<div class="traditional1">
  	 	<img src="/resources/uploads/한강사진.png">
  	 	<p>한강</p>
  	 </div>
  	 <div class="traditional1">
  	 	<img src="/resources/uploads/명동거리사진.jpg">
  	 	<p>명동거리</p>
  	 </div>
  	 <div class="traditional1">
  	 	<img src="/resources/uploads/남산타워.jpg">
  	 	<p>남산타워</p>
  	 </div>
  	 <div class="traditional1">
  	 	<img src="/resources/uploads/광화문사진.webp">
  	 	<p>광화문</p>
  	</div>
  	</div>

  </section>
  
<br>

</div>
   <%@ include file="./views/common/footer.jsp" %>
</body>
</html>