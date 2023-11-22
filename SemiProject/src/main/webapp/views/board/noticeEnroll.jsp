<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/board.css">

<title>NoticeEnroll</title>
</head>
<body class="Main_body">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>


	<section class="boardSection">

		<div class="divCenter">
			<h1>공지 사항</h1>
		</div>
		<form action="/noticeEnroll.do" method="POST">
			<div class="boardEnroll">
				<div class="divCenter2">
					<textarea name="title" id="title" cols="30" rows="10" class="titleText"
						placeholder="제목을 입력해주세요"></textarea>
					<textarea name="content" id="content" cols="30" rows="10" class="contentText"
						placeholder="내용을 입력해주세요"></textarea>
				</div>
			</div>
			<div class="divCenter4">
				<div class="divComments">
					<button class="attachmentBtn">파일 첨부</button>
					<textarea name="" id="" cols="30" rows="10" class="TextArea"
						disabled></textarea>
					<button class="attachmentBtn">제출</button>
				</div>
			</div>
		</form>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>