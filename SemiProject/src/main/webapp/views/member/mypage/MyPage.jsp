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
	<div class = MyPageTitle_area>
	<div class="MyPageTitle" >
		<h2 class="tit">마이페이지</h2>
		<ul class="menu">
			<li class="m1">
				<a href="/MyPageForm.do"  class="Main_a">
					<span>내정보</span>
				</a>
			</li>
			<li class="m2" >
				<a href="#"  class="Main_a">
					<span>예약 확인</span>
				</a>
			</li>
			<li class="m3">
				<a href="#"  class="Main_a">
					<span>문의 내역</span>
				</a>
			</li>
			<li class="m4">
				<a href="#"  class="Main_a">
					<span>탈퇴 요청</span>
				</a>
			</li>
		</ul>
	</div>
	</div>
	<div class="contents">
	<div >
		<h4>내 정보</h4>
	</div>
	<table class="tableTypeA tableJoinForm tableUserInfo2">
		<colgroup>
			<col width="13%" class="col1">
			<col class="col2">
		</colgroup>
		<tbody>
			<tr class="tr_info">
				<th>성명</th>
				<td></td>
			</tr>
			<tr class="tr_info">
				<th>아이디</th>
				<td>admin</td>
			</tr>
			<tr class="tr_info">
				<th>이메일</th>
				<td>sangin525@naver.com</td>
			</tr>
			<tr class="tr_info">
				<th>전화번호</th>
				<td>01076601359</td>
			</tr>
			<tr class="tr_info">
				<th>생년월일</th>
				<td>1992-05-25</td>
			</tr>
			<tr class="tr_info">
				<th>주소</th>
				<td>안양</td>
			</tr>
			<tr class="tr_info">
				<th>마일리지</th>
				<td>0</td>
			</tr>
		</tbody>
	</table>
	<div class="UpdateBtn">
		<a href="/MemberUpdateForm.do"  class="Main_a"><span>정보 수정</span></a>
	</div>
	</div>
</div>
	
	
		<%@ include file="../../common/footer.jsp"%>
</body>
</html>