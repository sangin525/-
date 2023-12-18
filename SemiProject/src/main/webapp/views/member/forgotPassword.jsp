<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/showPwd.css">
</head>
<body class="Main_body">
<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<section class="Main_section">
	<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <div class="message">
        <%= message %>
    </div>
<%
    }
%>

<a href="/" class="Main_a" id="non-signin">홈</a><a
				href="/SigninForm.do" class="Main_a" id="non-signin">로그인</a><a href="/FindIdForm.do" class="Main_a">아이디 찾기</a>
</section>
<%@ include file="../common/footer.jsp"%>
</body>
</html>