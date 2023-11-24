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
<body class ="Main_body">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>


    <section class="boardSection">
	<form id ="board-datail-form">
        <div class="boardRightDiv">
        	<input type="hidden" name="boardNo" value="${board.boardNo}">
        	<input type="hidden" name="boardViews" value="${board.title}">
        	<input type="hidden" name="boardName" value="${board.content}">
        	<input type="hidden" name="boardNo" value="${board.m_No}">
        	
            <span class="boardSpan">
                <p class="boardText">게시물 번호 : ${board.boardNo}</p>
                <p class="boardText" id ="boardViews" name ="boardViews" >조회수 : ${board.views}</p>
                <p class="boardText" id ="boardName" name="boardName">작성자 : ${board.name}</p>
            </span>
            <span class="boardSpan">
                <p class="boardText" id ="boardInDate" name="boardInDate">수정날짜 : ${board.inDate}</p>
            </span>
        </div>

        <!-- Title, Content -->
        <div class="boardEnroll">
            <div class="divCenter2">
                <textarea name="boardTitle" id="boardTitle" cols="30" rows="10" class="titleText" required disabled>${board.title}</textarea>
                <textarea name="boardContent" id="boardContent" cols="30" rows="10" class="contentText" required disabled>${board.content}</textarea>
            </div>
            
            <c:if test = "${sessionScope.no == board.m_No}">
            <div class="divRight" style ="margin-top: 5px"> 
            	<c:set var="btn" value="0"></c:set>         
                	<button id="submitBtn" onclick="boardUpdate()" class="modifyBtn" style="margin-right: 20px; display: none;">완료</button>
                	<button id="modifyBtn" type="button" onclick="boardDisabled()" class="modifyBtn" style ="margin-right: 20px">수정</button>
                </c:if>
                <button onclick="boardDelete()" class="modifyBtn">삭제</button>
            </div>
        </div>
	</form>
	
	
	
	
        <!-- 댓글 -->
        <div class="divCenter2" style ="margin-top:30px">
            <p class="font14">댓글</p>
            <div class="divCenter3">
                <textarea name="" id="" cols="30" rows="10" class="contentText2" disabled></textarea>
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