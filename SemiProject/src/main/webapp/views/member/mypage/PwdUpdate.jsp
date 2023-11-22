<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../common/head.jsp"%>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>


<div class="container">
	<%@ include file="../../common/sidebar.jsp"%>
	
	<div class="contents">
	<div >
		<h4>비밀번호 변경</h4>
	</div>
	<form action="PasswordUpdate.do" method="POST">
	<table class="tableTypeA tableJoinForm tableUserInfo2">
		<colgroup>
			<col width="13%" class="col1">
			<col class="col2">
		</colgroup>
		<tbody>
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
	<div class="BtnForm">
		<button type="submit">비밀번호 변경</button>
		<button type="button" onclick="back()">취소</button>
	</div>
	</form>
	</div>
</div>
	
	
		<%@ include file="../../common/footer.jsp"%>
</body>
</html>