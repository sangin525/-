<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
	<div class="table-title" >
		<h4>내 정보</h4>
	</div>
<br>
	<table class="mypage-table">
		<colgroup>
			<col width="13%" class="col1">
			<col class="col2">
		</colgroup>
		<tbody class = "mypage-tbody">
			<tr class="tr_info">
				<th>성명</th>
				<td><%=session.getAttribute("name") %></td>
			</tr>
			<tr class="tr_info">
				<th>아이디</th>
				<td><%=session.getAttribute("id") %></td>
			</tr>
			<tr class="tr_info">
				<th>이메일</th>
				<td><%=session.getAttribute("email") %></td>
			</tr>
			<tr class="tr_info">
				<th>전화번호</th>
				<td><%=session.getAttribute("phone") %></td>
			</tr>
			<tr class="tr_info">
				<th>생년월일</th>
				<td><%=session.getAttribute("birth") %></td>
			</tr>
			<tr class="tr_info">
				<th>우편번호</th>
				<td class="mypage_addr"><%=session.getAttribute("addr") %></td>
			</tr>
			<tr class="tr_info">
				<th>주소</th>
				<td><%=session.getAttribute("addr1") %>&nbsp;<%=session.getAttribute("addr2") %></td>
			</tr>
			<tr class="tr_info">
				<th>마일리지</th>
				<td><%=session.getAttribute("mlg") %></td>
			</tr>
			<tr class="tr_info">
				<th>멤버십 등급</th>
				<td><%=session.getAttribute("membership") %></td>
			</tr>
			<tr class="tr_info">
				<th>누적 숙박금액</th>
				<td><%=session.getAttribute("accamount") %></td>
			</tr>
		</tbody>
	</table>
	<br>
		<div id="btn-group">
			<button class="left-btn" onclick="location.href='/MemberUpdateForm.do' "
			>정보 수정</button>
		</div>
	</div>
	</div>
</div>
	
	
		<%@ include file="../../common/footer.jsp"%>
</body>
</html>