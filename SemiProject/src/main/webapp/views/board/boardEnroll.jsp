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
		<!-- 문의 사항 글자 -->
		<div>
			<div class="divSort">
				<h1 style="margin-bottom:0;">문의 사항</h1>
			</div>
				<ul class="BoardEnrollUl">
					<li>객실 문의<input type="checkbox"></li>
					<li>예약 문의<input type="checkbox"></li>
					<li>시설 문의<input type="checkbox"></li>
					<li>회원가입 및 로그인 문의<input type="checkbox"></li>
					<li>기타 문의<input type="checkbox"></li>
				</ul>
		</div>
		
		<!-- 본문 내용 Title, Content -->
		<form action ="/boardEnroll.do" method ="POST" enctype="multipart/form-data">
				<div class="divCenter2">
					<textarea name="title" id="title" cols="30" rows="10" class="titleText"
						placeholder="제목을 입력해주세요"></textarea>
					<div id="smarteditor" class="smarteditor">
						<textarea name="contents" id="contents" cols="30" rows="10" placeholder="내용을 입력해주세요" class="contentText" style="width:100%; height: 170px"></textarea>
					</div>
				</div>
			
			<div class="divCenter4">
					<!-- 파일 첨부 -->
					<div>
						<label for="file" class="input-file-button" style="width:70px; margin-right:10px;">파일 첨부</label>
						<input type="file" id ="file" name="file" style="display:none;" onchange="displayFileName(this)">
					
						<input class="upload-name" disabled>
					</div>
					<button type="submit" class="right-btn-board" onclick="save()">제출</button>
			</div>
		</form>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>