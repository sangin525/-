<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/board.css">
<script src="/resources/js/board/board.js"></script>
<title>BoardList</title>
</head>
<body class="Main_body">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>


	<section class="boardSection">
		<form id="board-datail-form">
			<div class="boardRightDiv">
				<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}">
				<input type="hidden" name="boardViews" value="${board.title}">
				<input type="hidden" name="boardName" value="${board.content}">
				<input type="hidden" name="boardMemberNo" value="${board.m_No}"> 
					<span class="boardSpan">
						<p class="boardText">게시물 번호 : ${board.boardNo}</p>
						<p class="boardText" id="boardViews" name="boardViews">조회수 : ${board.views}</p>
						<p class="boardText" id="boardName" name="boardName">작성자 : ${board.name}</p>
					</span> 
				<span class="boardSpan">
					<p class="boardText" id="boardInDate" name="boardInDate">수정날짜 :
						${board.inDate}</p>
				</span>
			</div>

			<!-- Title, Content -->
				<div class="boardEnroll">
					<div class="divCenter2">
						<textarea name="boardTitle" id="boardTitle" cols="30" rows="10" class="titleText" required disabled>${board.title}</textarea>
						<textarea name="boardContent" id="boardContent" cols="30" rows="10" class="contentText" required disabled>${board.content}</textarea>
					</div>
	
					<c:if test="${sessionScope.no == board.m_No}">
						<div class="divRight" style="margin-top: 5px">
							<c:set var="btn" value="0"></c:set>
							<button id="submitBtn" onclick="boardUpdate()" class="right-btn-board"
								style="margin-right: 20px; display: none;">완료</button>
							<button id="modifyBtn" type="button" onclick="boardDisabled()"
								class="right-btn-board" style="margin-right: 20px">수정</button>
					</c:if>
					<button onclick="boardDelete()" class="right-btn-board" style="margin-right:110px;">삭제</button>
				</div>
			</div>
		</form>




		<!-- 댓글 -->
		<form action="answerEnroll.do" method="POST">
			<div class="divCenter2">
				<p class="font14">답변</p>
					<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}"> <!-- boardNo 받아오는 Hidden 값 -->
				
				<div class="divCenter3">
					<div class="divComments"> <!-- 답변 입력칸 -->
						<textarea name="comment" id="comment" cols="30" rows="10" class="contentText3" placeholder="답변을 입력해주세요"></textarea>
						<button name="answerEnroll" id="answerEnroll" type="submit" class="right-btn-board" style="width:15%; height:41px; margin-top:5px;margin-left:5px;">입력</button>
					</div>
					
					<!-- List -->
					<div class="answerDiv">
						<span class="answerSpan">
							<p class="answerText">작성자 : </p>
							<p class="answerText">작성 날짜 : </p>
							<p class="answerText">수정 날짜 : </p>
							<a href="#" class="answerText">삭제</a>
						</span>
						<textarea name="" id="" cols="30" rows="10" class="contentText2" disabled></textarea>					
					</div>
				</div>
				
			</div>
		</form>


	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>