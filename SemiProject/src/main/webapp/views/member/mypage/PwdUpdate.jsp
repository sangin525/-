<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/MyPage.css">
<script src="/resources/js/member/member.js"></script>
</head>
<body class="Main_body">
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>

<div class="main-container">
	<div class="container-center">
	<%@ include file="../../common/sidebar.jsp"%>
	
	<div class="contents">
	<div class="table-title">
		<h4>비밀번호 변경</h4>
	</div>
	<br>
	<form action="PasswordUpdate.do" method="POST">
	<table class="mypage-table">
		<colgroup>
			<col width="13%" class="col1">
			<col class="col2">
		</colgroup>
		<tbody class = "mypage-tbody">
			<tr class="tr_info">
				<th>현재 비밀번호</th>
				<td><input type = "password" id = "password" name = "password"></td>
			</tr>
			<tr class="tr_info">
				<th>새 비밀번호 </th>
				<td><input type = "password" id = "newPassword" name = "newPassword" onkeyup="validatePassword()"><span id="PwdMsg"></span></td>
			</tr>
			<tr class="tr_info">
				<th>새 비밀번호 확인</th>
				<td><input type = "password" id = "passwordChk" name = "passwordChk" onkeyup="validatePassword()"><span id="PwdChkMsg"></span></td>
			</tr>
		</tbody>
	</table>
	<br>
<div id="btn-group">
		<button type="submit" class="left-btn">비밀번호 변경</button>
		<button type="button" class="right-btn" onclick="back()">취소</button>
	</div>
	</form>
	</div>
	</div>
</div>
	
	
		<%@ include file="../../common/footer.jsp"%>
</body>
</html>