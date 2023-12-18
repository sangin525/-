<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>아이디 찾기</title>
    <%@ include file="../common/head.jsp"%>
    <link rel="stylesheet" href="/resources/css/member/showId.css">
</head>
<body class="Main_body">
<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<section class="Main_section">
    <h1>아이디 찾기 결과</h1>
    <% String userId = (String) request.getAttribute("foundId"); %>
    <% if (userId != null) { %>
        <p>찾은 아이디: <%= userId %></p>
    <% } %> 
    
    <div class="member-btn-box">
			<a href="/" class="Main_a" id="non-signin">홈</a><a href="/SigninForm.do" class="Main_a" id="non-signin">로그인</a><a href="/FindPwdForm.do"  class="Main_a">비밀번호 찾기</a>
			</div>
    </section>
    <%@ include file="../common/footer.jsp"%>
</body>
</html>
