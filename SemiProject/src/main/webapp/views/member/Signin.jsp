<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/Signin.css">
<script src="/resources/js/member/member.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<div class="Signin-main">
		
		<div class="SignIn">
			<h2>SignIn</h2>
		</div>
		<form action="/Signin.do" method="POST">
			<div class="input-box" >
				<input type="text" id="id" name="id" placeholder="아이디" required> 
				<label for="id">아이디 </label>
			</div>
			<div class="input-box">
				<input type="password" id="password" name="password" placeholder="비밀번호" required>
				<label for="password">비밀번호</label>
			</div>
			<input type="submit" value="로그인">
			
			<!--  <button type="submit">로그인</button>-->
		</form>
		
	</div>


	<%@ include file="../common/footer.jsp"%>

</body>
</html>