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
   

<img class="change-image"></img>

  <section class="Main_section">

    <h2>홈</h2>
    
    <p> 안녕하세요! 홈페이지에 오신 것을 환영합니다.qqqq11221</p>

  </section>

</div>
   <%@ include file="./views/common/footer.jsp" %>
</body>
</html>