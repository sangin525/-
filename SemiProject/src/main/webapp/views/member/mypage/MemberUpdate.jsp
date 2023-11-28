<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/MyPage.css">
<script src="/resources/js/member/member.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/member/memberUpdate.js"></script>
</head>
<body class="Main_body">
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>
	
<div class="main-container">
	<div class="container-center">
	<%@ include file="../../common/sidebar.jsp"%>
	
	<div class="contents">
	<div class="table-title">
		<h4>프로필 수정</h4>
	</div>
		<div>
		<h4>개인정보</h4>
	</div>
	<form action="MemberUpdate.do" method="POST">
	<table class="mypage-table">
		<colgroup>
			<col width="13%" class="col1">
			<col class="col2">
		</colgroup>
		<tbody class = "mypage-tbody">
			<tr class="tr_info">
				<th>성명</th>
				<td><input type="text" id="id" name="name" value="${sessionScope.name}" disabled></td>
			</tr>
			<tr class="tr_info">
				<th>아이디</th>
				<td><input type="text" id="id" name="name" value="${sessionScope.id}" disabled></td>
			</tr>
			<tr class="tr_info">
				<th>전화번호</th>
				<td><input type="text" id="phone" name="phone" value="${sessionScope.phone}"></td>
			</tr>
			<tr class="tr_info">
				<th>이메일</th>
				<td><input type="text" id="email" name="email" value="${sessionScope.email}"></td>
			</tr>

			<tr class="tr_info">
				<th>우편번호</th>
				<td><input type="text" id="addr" name="addr" value="${sessionScope.addr}">&nbsp;<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></td>
			</tr>
			<tr class="tr_info">
				<th>주소</th>
				<td><input type="text" id="addr1" name="addr1" value="${sessionScope.addr1}">&nbsp;<input type="text" id="addr2" name="addr2" value="${sessionScope.addr2}"></td>
			</tr>
			<tr class="tr_info">
				<th>생년월일</th>
				<td><input type="text" id="birth" name="birth" value="${sessionScope.birth}" disabled></td>
			</tr>
			<tr class="tr_info">
				<th>마일리지</th>
				<td><input type="text" id="mlg" name="mlg" value="${sessionScope.mlg}" disabled></td>
			</tr>
		</tbody>
	</table>
	<br>
<div id="btn-group">
		<button type="submit" class="left-btn">수정</button>
		<button type="button" class="right-btn" onclick="back()">취소</button>
	</div>

	</form>
	</div>
	</div>
</div>
	
	
	
	
	<%@ include file="../../common/footer.jsp"%>
</body>
</html>