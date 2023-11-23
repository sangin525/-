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
	<div >
		<h4>탈퇴 요청</h4>
	</div>
	<br>
	<form action="MemberDeleteDetail.do" method="POST">
		<div>
		<p>탈퇴를 신청하시기 전에 아래의 유의사항을 한 번 더 확인해 주시기 바랍니다.</p>
		<ul>
			<li>- 탈퇴를 신청하시면 번복이 불가능하며, 보유하신 마일리지는 소멸됩니다.</li>
			<li>- 개인정보보호법에 따라 고객님의 호텔 이용기록, 개인정보 및 문의내역 기록도 모두 삭제됩니다.</li>
			<li>- 탈퇴 신청이 완료되면 즉시 홈페이지 로그인이 제한됩니다.</li>
		</ul>
		</div>
		<br>
		<div id="btn-group">
		<button type="submit" class="left-btn">신청</button>
		<button type="button" class="right-btn" onclick="back()">취소</button>
	</div>

	</form>
	</div>
	</div>
</div>
	
	
	
	
	<%@ include file="../../common/footer.jsp"%>
</body>
</html>