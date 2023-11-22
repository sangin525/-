<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/MyPage.css">

</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>
	
<div class="container">
	<%@ include file="../../common/sidebar.jsp"%>
	
	
	<div class="contents">
	<div >
		<h4>회원탈퇴 요청</h4>
	</div>
	<form action="MemberDelete.do" method="POST">
	<table class="tableTypeA tableJoinForm tableUserInfo2">
		<colgroup>
			<col width="13%" class="col1">
			<col class="col2">
		</colgroup>
		<tbody>
			<tr class="tr_info">
				<th>아이디</th>
				<td><input type="text" id="id" name="name" value="${sessionScope.id}" disabled></td>
			</tr>
			<tr class="tr_info">
				<th>비밀번호</th>
				<td><input type="password" id="deletePwd" name="deletePwd"></td>
			</tr>
		</tbody>
	</table>
		<button type="submit">탈퇴요청</button>
		<button type="button" onclick="back()">취소</button>
	<div class="BtnForm">
	<div class="UpdateBtn">
	</div>
	<div class="CancelBtn">
	</div>
	</div>
	</form>
	</div>
</div>
	
	
	
	
	<%@ include file="../../common/footer.jsp"%>
</body>
</html>