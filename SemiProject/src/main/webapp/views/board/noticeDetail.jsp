<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/board.css">

<title>BoardList</title>
</head>
<body class ="Main_body">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>


	<section class="boardSection">

		<div class="boardRightDiv">
			<span class="boardSpan">
				<p class="boardText">게시물 번호 : 1</p>
				<p class="boardText">조회수 : 1</p>
				<p class="boardText">작성자 : ***</p>
			</span> <span class="boardSpan">
				<p class="boardText">수정날짜 : YYYY-MM-DD</p>
			</span>
		</div>

		<!-- Title, Content -->
		<div class="boardEnroll">
			<div class="divCenter2">
				<textarea name="" id="" cols="30" rows="10" class="titleText"
					disabled></textarea>
				<textarea name="" id="" cols="30" rows="10" class="contentText"
					disabled></textarea>
			</div>
			<div class="divRight">
				<button class="modifyBtn">수정</button>
			</div>
		</div>

		<!-- 댓글 -->
		<div class="divCenter2">
			<p class="font14">댓글</p>
			<div class="divCenter3">
				<textarea name="" id="" cols="30" rows="10" class="contentText2"
					disabled></textarea>
				<div class="divComments">
					<textarea name="" id="" cols="30" rows="10" class="contentText3"></textarea>
					<button type="submit" class="Btn2">입력</button>
				</div>
			</div>
		</div>



	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>