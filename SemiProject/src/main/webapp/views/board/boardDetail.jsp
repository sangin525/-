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
					<input type="hidden" name="boardMemberNo" value="${board.m_No}"> 
					<span class="boardSpan">
					<p class="boardText">게시물 번호 : ${board.boardNo}</p>
					<p class="boardText" id="boardViews" name="boardViews">조회수 :
						${board.views}</p>
					<p class="boardText" id="boardName" name="boardName">작성자 :
						${board.name}</p>
				</span> <span class="boardSpan">
					<p class="boardText" id="boardInDate" name="boardInDate">수정날짜 :
						${board.inDate}</p>
				</span>
			</div>

			<!-- Title, Content -->
			<div class="boardEnroll">
				<div class="divCenter2">
					<textarea name="boardTitle" id="boardTitle" cols="30" rows="10"
						class="titleText" required disabled>${board.title}</textarea>
					<div name="boardContent" id="boardContent" class="contentText">${board.content}</div>
				</div>

				<c:if test="${sessionScope.no == board.m_No}">
					<div class="divRight" style="margin-top: 5px">
						<c:set var="btn" value="0"></c:set>
						<button id="modifyBtn" type="button" onclick="boardUpdateFormSend()" class="right-btn-board" style="margin-right: 20px">수정</button>
						<button onclick="boardDelete()" class="right-btn-board" style="margin-right: 110px;">삭제</button>
					</div>
				</c:if>
			</div>
		</form>




		<!-- 댓글 -->

			<div class="divCenter2" style="height:170px;">
				<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}">
				<!-- boardNo 받아오는 Hidden 값 -->
				<div class="divCenter3">
					<!-- List -->
					<div class="answerDiv">
						<div class="contentText2" style="height: 120px;">
							<span class="answerSpan">
								<p class="answerText">작성자 : ${board.answerWriter}</p>
								<p class="answerText" style="width: 150px;">작성 날짜 : ${board.answerOnDate}</p>
								<p class="answerText" style="width: 150px; padding-right:35px;">수정 날짜 : ${board.answerInDate}</p>
								<input type="hidden" value="${board.answerNo}" name="answerNo">
								<c:if test="${sessionScope.admin eq 'Y'}">
									<c:choose>
										<c:when test="${board.answerContent eq null}">
											<a onclick="answerInput();" class="answerTextClick"
											style="width: 30px; text-align: center;">작성</a> 
										</c:when>
										<c:otherwise>
											<a onclick="answerInput();" class="answerTextClick"
											style="width: 30px; text-align: center;">수정</a> 
										</c:otherwise>
									</c:choose>
										<a onclick="answerDelete();" class="answerTextClick"
										style="width: 30px; text-align: center;">삭제</a>
								</c:if>
							</span>
								
							<p style="padding-left: 5px; height: 80px;">${board.answerContent}</p>
						</div>
					</div>
				</div>
			</div>

				<!-- action="answerEnroll.do" method="POST" -->
				<form action="answerEnroll.do" method="POST" id="answer-form">
							<!-- 답변 입력칸 -->
					<input type="hidden" id="answerNo" name="answerNo" value="${board.answerNo}"> 
					<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}"> 
					<div id="answerInput" class="answerInput">
						<div class="divComments">
							<textarea name="comment" id="comment" cols="30" rows="10"
								class="contentText3" placeholder="답변을 입력해주세요"></textarea>
									
									<c:choose>
										<c:when test="${board.answerContent eq null}">
											<!-- Enroll submit 버튼 -->
											<button name="answerEnroll" id="answerEnroll" type="submit"
											class="right-btn-board"
											style="width: 15%; height: 41px; margin-top: 5px; margin-left: 5px;">입력</button>
										</c:when>
										<c:otherwise>
											<!-- Update submit 버튼 -->
											<button type="button" class="right-btn-board" onclick="answerUpdate();" style="width: 15%; height: 41px; margin-top: 5px; margin-left: 5px;">수정</button>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</form>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>