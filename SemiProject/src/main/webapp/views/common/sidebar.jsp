<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="/resources/css/member/sidebar.css">
	
	<div class = "warpper">
		<nav id = "sidebar">
		<h2 class="sidebar-title">마이페이지</h2>
		<ul class="list-items">
			<li class="item">
				<a href="/MyPageForm.do">
					<span>내정보</span>
				</a>
			</li>
				<li class="item">
				<a href="/PwdUpdateForm.do">
					<span>비밀번호 변경</span>
				</a>
			</li>
			<li class="item">
				<a href="/MyReserve.do?cpage=1">
					<span>예약 확인</span>
				</a>
			</li>
			<li class="item">
				<a href="/MyBoardList.do?cpage=1">
					<span>문의 내역</span>
				</a>
			</li>
			<li class="item">
				<a href="/MemberDeleteForm.do">
					<span>탈퇴 요청</span>
				</a>
			</li>
		</ul>
	
		</nav>
	</div>