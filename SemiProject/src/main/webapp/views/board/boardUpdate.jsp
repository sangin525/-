<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<script type="text/javascript" src="/resources/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="/resources/js/board/board.js"></script>
<link rel="stylesheet" href="/resources/css/board.css">

<title>BoardEnroll</title>
</head>
<body class="Main_body" onload="editorLoading('', '');" style = "background-color:white;">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>


	<section class="boardSection">
	<form action ="/boardUpdate.do" method ="POST">
		<div style="border-bottom:3px solid #ffd2d2; margin-bottom:10px;">
			<div class="divSort">
				<h1 style="margin-bottom:0;">문의 사항</h1>
				<li class="BoardEnrollLi">비밀글<input type="checkbox" id="secretBox" name="secretBox"></li>
			</div>
				<ul class="BoardEnrollUl">
					<li>객실 문의<input type="checkbox"></li>
					<li>예약 문의<input type="checkbox"></li>
					<li>시설 문의<input type="checkbox"></li>
					<li>회원가입 및 로그인 문의<input type="checkbox"></li>
					<li>기타 문의<input type="checkbox"></li>
				</ul>
		</div>
		
		<div class="divCenter" style="min-width:1000px;">
			<h1>문의 사항</h1>
		</div>
		

			<div class="boardEnroll">
				<div class="divCenter2">
					<input type="hidden" id="boardNo" name="boardNo" value="${sessionScope.boardNo}">
					<textarea name="title" id="title" cols="30" rows="10" class="titleText"
						placeholder="제목을 입력해주세요"></textarea>
					<div id="smarteditor" class="smarteditor">
						<textarea name="contents" id="contents" cols="30" rows="10" placeholder="내용을 입력해주세요" class="contentText" style="width:100%; height: 170px"></textarea>
					</div>
				</div>
			</div>
			<div class="divCenter4" style="justify-content:flex-end">
					<button style="justify-content:center;" type="submit" class="right-btn-board" onclick="save()">제출</button>
				</div>
		</form>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>