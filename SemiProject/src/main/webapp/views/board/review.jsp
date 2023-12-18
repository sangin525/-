<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>
<script src="/resources/js/board/review.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/review.css">
<link rel="stylesheet" href="/resources/css/member/MyPage.css">
</head>
<body class="Main_body">
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>
	<input type="hidden" name="cpage" value="1">
	<div class="header-container">
		<div class="review-header">
			<h2>REVIEW</h2>
			<p>
				호텔 하루 이용에 대한 소중한 경험을 나눠주세요.<br> 리뷰를 남겨 주시면 추첨을 통해 소정의 상품을 드립니다.
			</p>
		</div>
	</div>
	<div class="review-container">
		<div class="review-btn">
		<c:choose>
				<c:when test="${sessionScope.no !=null}">
					<button type="button" class="left-btn" 
	       				 onclick="location.href='/board/review.do'">리뷰작성</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="left-btn"
						onclick="alert('로그인후 이용해주세요')">예약하기</button>
				</c:otherwise>
			</c:choose>

		</div>
		<ul class="review-box">
			<c:choose>
				<c:when test="${empty list}">
					<p>등록된 리뷰가 없습니다.</p>
				</c:when>
				<c:otherwise>
					<c:forEach var="item" items="${list}">
						<li class="review">
					<form id="review-form">
						<input type="hidden" id="reviewNo" name="reviewNo" value="${item.reviewNo}">
							<div class="review-star-update-delete">
							<c:if test="${item.id==sessionScope.id}">
							<div class="review-update-delete">
								<button onclick="reviewUpdate(this)">수정</button>
								<button onclick="reviewDelete(this)">삭제</button>
							</div>
							</c:if>
							<div class="review-star" id="star-rating">
								<div class="stars-outer">
									<div class="stars-inner"
										style="width:${(item.star * 100) / 5}%"></div>
								</div>
								<div class="star-number">${item.star}</div>
							</div>
							</div>
							<div class="review-item">
								<p class="rv-id" name="rv-id">${item.id}<span class="rv-date">${item.reviewInDate}</span>
								</p>
								<p class="rv-title">${item.reviewTitle}</p>
								<p class="rv-content">${item.reviewContent}</p>
							</div>
							<div class="review-imgbox">
								<c:forEach var="photo" items="${item.fileNames}">
									<img src="../../resources/uploads/review/${photo}"
										style="width: 100px; height: 100px;">
								</c:forEach>
							</div>
					</form>
						</li>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
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
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>