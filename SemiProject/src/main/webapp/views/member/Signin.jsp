<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/Signin.css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>

	<section class="login_form">
		<div>
			<form action="/Signin.do" method="POST">
				<div >
				<label for="id">아이디 : </label> <br>
				<input class="inputBox" type="text" id="id" name="id" required> 
				<br>
				<label for="password">비밀번호 : </label> <br>
				<input class="inputBox" type="password" id="password" name="password" required>
				<br><br>
				<button class="btn btn-primary" type="submit">로그인</button>
					<!--  <button type="submit">로그인</button>-->
				</div>
			</form>


		</div>
	</section>

	<%@ include file="../common/footer.jsp"%>

</body>
</html>