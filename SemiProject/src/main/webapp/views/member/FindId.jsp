<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/FindId.css">
<script src="/resources/js/member/member.js"></script>
</head>
<body class="Main_body">
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<div class="FindId-contain">
		<div class="FindId-main">
			<div class="FindId">
				<h2>아이디찾기</h2>
			</div>
			<form id="frm" action="FindId.do"
				method="post">
				<div class="input-box">
					<input type="text" id="name" name="name" placeholder="이름" required> 
					<label for="id">이름 </label>
				</div>
				<div class="input-box">
					<input type="email" id="email" name="email" placeholder="이메일" required>
					<label for="email">이메일</label>
				</div>
				<div class="member-btn-box">
					<input type="submit" value="아이디 찾기">
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>