<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/board.css">
<script src="/resources/js/board/board.js"></script>

<title>Notice Detail</title>
</head>
<body class="Main_body" style="background-color:white;">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>

	<section class="boardSection">
		<form id="notice-datail-form">
			<p class="detailP">공지사항</p>
			<!-- boardTitle -->
			<div name="boardTitle" id="boardTitle" class="detailtitleText">${board.title}</div>
			
			<!-- 세부정보 -->
			<div class="boardRightDiv">
			
				<!-- hidden input 모음 -->
				<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}"> 
				<input type="hidden" name="boardViews" value="${board.title}"> 
				<input type="hidden" name="boardMemberNo" value="${board.m_No}"> 
				
				<!-- 주요 세부정보 모음 -->
				<span class="boardSpan">
					<img src="/resources/boardIcon/file-earmark.svg"/><p class="boardText">게시물 번호 : ${board.boardNo}</p>
					<img src="/resources/boardIcon/eye.svg"/><p class="boardText" id="boardViews" name="boardViews">조회수 : ${board.views}</p>
				</span> 
				<span class="boardSpan2">
					<span class="boardSpan">
						<img src="/resources/boardIcon/person-fill.svg"/><p class="boardText" id="boardName" name="boardName">작성자 : ${board.name}</p>
					</span>
					<span class="boardInDate">
						<img src="/resources/boardIcon/calendar-fill.svg"/><p class="boardDateText" id="boardInDate" name="boardInDate">수정날짜 : ${board.inDate}</p>
					</span>
				</span>
			</div>

			<!-- Content -->
				<div class="divCenter2">
					<!-- **Content Div -->
					<div name="boardContent" id="boardContent" class="detailContent">${board.content}</div>
				</div>
				
			<!-- 첨부파일 및 수정, 삭제 등 버튼 모음 -->
			
				<c:if test="${sessionScope.no == board.m_No}">
					<div class="divRight" style="margin-top: 5px">
						<input name="route" id="route" type="hidden" value="${board.route}">
						<c:set var="btn" value="0"></c:set>
						<c:if test="${not empty board.photo}">
						<!-- 첨부파일 -->
							<div class="divFile">
							    <p>첨부 파일 : </p><a id="photo" name="photo" onclick="fileDownload('${board.photo}','${board.route}')" 
							    href="/BoardDownload.do?filePath=${board.route}&fileName=${URLEncoder.encode(board.photo, 'UTF-8')}" target="_blank">${board.photo}</a>
							</div>
						</c:if>
						<div class="divbuttonSort">
						
							<span class="detailBtnSpan">
								<button id="modifyBtn" type="button" onclick="noticeUpdateFormSend()" class="right-btn-board">
									<img class="btnStyle" src="/resources/boardIcon/pen.svg">수정
								</button>
								<button onclick="noticeDelete()" class="right-btn-board">
									<img class="btnStyle" src="/resources/boardIcon/trash3.svg">삭제
								</button>
							</span>
							
							<span class="divbuttonSort">
								<div class="right-btn-board"><img class="btnStyle" src="/resources/boardIcon/list-task.svg"><a class="aBtn" href="/NoticeList.do?cpage=1">목록</a></div>
								<div class="right-btn-board"><img class="btnStyle" src="/resources/boardIcon/file-earmark-plus.svg"><a class="aBtn" href="/views/notice/noticeEnroll.jsp">글 작성</a></div>
							</span>
						</div>
					</div>
				 </c:if>
		</form>


		<!-- 댓글 -->
			<div class="answerSortDiv">
			 	<p><img class="img" src="/resources/boardIcon/chat-dots.svg">댓글</p>
			</div>
			
			<div class="divAnswerBox">
				<!-- boardNo 받아오는 Hidden 값 -->
				<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}">
				
						<div class="contentText2">
							<span class="answerSpan">
								<p class="answerText">작성자 : ${board.commentWriter}</p>
								<p class="answerTextDate">작성 날짜 : ${board.commentOnDate}</p>
								<p class="answerTextDate">수정 날짜 : ${board.commentInDate}</p>
								<input type="hidden" value="${board.commentNo}" name="answerNo">
								
								<div>
										<c:choose>
											<c:when test="${board.commentContent eq null}">
												<a onclick="commentInput();" class="answerTextClick"
												style="width: 30px; text-align: center;">작성</a> 
											</c:when>
											<c:otherwise>
												<a onclick="commentInput();" class="answerTextClick"
												style="width: 30px; text-align: center;">수정</a> 
											</c:otherwise>
										</c:choose>
											<a onclick="commentDelete();" class="answerTextClick"
											style="width: 30px; text-align: center;">삭제</a>
								</div>
							</span>
								
							<p class="answerContent">${board.commentContent}</p>
						</div>
					</div>


				<form action="commentEnroll.do" method="POST" id="comment-form">
					<!-- 답변 입력칸 -->
					<input type="hidden" id="commentNo" name="commentNo" value="${board.commentNo}"> 
					<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}"> 
						
						<!-- Default값 display:none -->					
					<div id="commentInput" class="answerInput">
					
					
						<div class="divSortAnswer">
							<input name="comment" id="comment" 
								class="detailSortInput" placeholder="답변을 입력해주세요">
									
									<c:choose>
										<c:when test="${board.commentContent eq null}">
											<!-- Enroll submit 버튼 -->
											<button name="commentEnroll" id="commentEnroll" type="submit"
											class="answerSubmitBtn">입력</button>
										</c:when>
										<c:otherwise>
											<!-- Update submit 버튼 -->
											<button type="button" class="answerSubmitBtn" onclick="commentUpdate();">수정</button>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</form>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>