<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/FindPwd.css">
<script src="/resources/js/member/member.js"></script>


</head>
<body class="Main_body">
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<div class="ChangePwd-contain">
		<div class="ChangePwd-main">

			<div class="ChangePwd">
				<h2>비밀번호 찾기</h2>
			</div>
			<form id="frm" action="/FindPwd.do"
				method="post" accept-charset="UTF-8">
				<div class="input-box">
					<input type="text" id="name" name="name" placeholder="이름" required> 
					<label for="id">이름 </label>
				</div>
				<div class="input-box">
					<input type="text" id="id" name="id" placeholder="아이디" required>
					<label for="text">아이디</label>
				</div>
				<div class="member-btn-box">
					<input type="submit" value="비밀번호 찾기">
				</div>
			</form>

		</div>

	</div>
	<%@ include file="../common/footer.jsp"%>

</body>
</html>