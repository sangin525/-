<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
</head>
<body class="Main_body">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>
	<input type="hidden" name="cpage" value="1">
	<ul class="review-box">
		<c:choose>
			<c:when test="${empty list}">
				<p>등록된 리뷰가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="item" items="${list}">
					<li class="review">
						<div class="review-item">
							<p class="rv-id">${item.id}<span>${item.inDate}</span>
							</p>
							<p class="rv-title">${item.reviewTitle}</p>
							<p class="rv-content">${item.reviewContent}</p>
						</div>
						<div class="review-star">${item.star}</div>
						<div class="review-imgbox">
							<c:forEach var="photo"
								items="${fn:split(item.reviewPhotos, ',')}">
								<img src="/resources/uploads/review/${fn:trim(photo)}"
									style="width: 100px; height: 100px;">
							</c:forEach>
						</div>
					</li>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</ul>
	<nav class="pageNav">
		<ul class="pagination">

			<c:choose>
				<c:when test="${pi.currentPage == 1}">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:when>

				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="/reviewList.do?cpage=${pi.currentPage-1}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:otherwise>
			</c:choose>



			<!-- 1부터 10까지의 버튼 나열 -->
			<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
				<!-- if문을 작성해 현재 페이지가 pageNum과 동일하면 active 클래스가 추가된 리스트가 보여지도록 함 -->
				<c:if test="${pi.currentPage == page}">
					<li class="page-item-active"><a class="page-link"
						href="/reviewList.do?cpage=${page}">${page} </a></li>
				</c:if>

				<!-- 현재 페이지와 pageNum이 동일하지 않은 9개의 버튼은 active가 활성화되지 않은 리스트가 보여지도록 함 -->
				<c:if test="${pi.currentPage != page}">
					<li class="page-item"><a class="page-link"
						href="/reviewList.do?cpage=${page}">${page} </a></li>
				</c:if>
			</c:forEach>

			<c:choose>
				<c:when test="${pi.currentPage == pi.maxPage}">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:when>

				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="/reviewList.do?cpage=${pi.currentPage+1}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>

	<button class="left-btn"
		onclick="location.href='/views/board/reviewEnroll.jsp' ">정보
		수정</button>


	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>