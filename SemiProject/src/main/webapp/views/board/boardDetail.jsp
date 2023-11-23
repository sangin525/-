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

        <div class="boardRightDiv">
        	<input type="hidden" name="boardNo">
            <span class="boardSpan">
                <p class="boardText" id ="boardNo" name ="boardNo">게시물 번호 : ${board.boardNo}</p>
                <p class="boardText" id ="boardViews" name ="boardViews">조회수 : ${board.views}</p>
                <p class="boardText" id ="boardName" name="boardName">작성자 : ***</p>
            </span>
            <span class="boardSpan">
                <p class="boardText" id ="boardInDate" name="boardInDate">수정날짜 : ${board.inDate}</p>
            </span>
        </div>

        <!-- Title, Content -->
        <div class="boardEnroll">
            <div class="divCenter2">
                <textarea name="boardTitle" id="boardTitle" cols="30" rows="10" class="titleText" disabled>${board.title}</textarea>
                <textarea name="boardContent" id="boardContent" cols="30" rows="10" class="contentText" disabled>${board.content}</textarea>
            </div>
            <div class="divRight">
                <button class="modifyBtn">수정</button>
            </div>
        </div>

        <!-- 댓글 -->
        <div class="divCenter2">
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