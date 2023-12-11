<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<script src="/resources/js/board/review.js"></script>
<link rel="stylesheet" href="/resources/css/review.css">
<%@ include file="../common/head.jsp"%>
</head>
<body class="Main_body">
<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<div class="review-container">
		<form action="/reviewEnroll.do" method="post" enctype='multipart/form-data'>
		<div class="review-content">
			<label for="title">1. 호텔 하루 이용 중 가장 기억에 남는 점을 알려주세요.</label>
			<input type="text" class="review-text" id="title" name="title">
		</div>
		<div class="review-content">
			<label for="content">2. 이용 중 경험을 작성해 주세요.</label>
			<textarea class="review-text" id="content" name="content"></textarea>
		</div>
		<div class="review-content">
			<label for="room">3. 이용하신 객실은 무엇인가요?</label>
			<input type="text" class="review-text" id="room" name="room">
		</div>
		<div class="review-content">
			<label for="date">4. 언제 이용하셨나요?</label>
			<div class="form-row">
				<select name="year">
    				<option value="2023년">2023년</option>
    				<option value="2022년">2022년</option>
    				<option value="2021년">2021년</option>
				</select>
				<select name="month">
    				<option value="1월">1월</option>
    				<option value="2월">2월</option>
    				<option value="3월">3월</option>
    				<option value="4월">4월</option>
    				<option value="5월">5월</option>
    				<option value="6월">6월</option>
    				<option value="7월">7월</option>
    				<option value="8월">8월</option>
    				<option value="9월">9월</option>
    				<option value="10월">10월</option>
    				<option value="11월">11월</option>
    				<option value="12월">12월</option>
				</select>
			</div>
		</div>
		<div class="review-content">
	<label for="type">5. 누구와 함께 이용하셨나요?</label>
	<div class="check-box">
		<input type="radio" name="withWho" id="withWho_0" value="가족">
		<label for="withWho_0"><span>가족</span></label>
	</div>
	<div class="check-box">
		<input type="radio" name="withWho" id="withWho_1" value="친구">
		<label for="withWho_1"><span>친구</span></label>
	</div>
	<div class="check-box">
		<input type="radio" name="withWho" id="withWho_2" value="커플">
		<label for="withWho_2"><span>커플</span></label>
	</div>
	<div class="check-box">
		<input type="radio" name="withWho" id="withWho_3" value="비즈니스">
		<label for="withWho_3"><span>비즈니스</span></label>
	</div>
	<div class="check-box">
		<input type="radio" name="withWho" id="withWho_4" value="혼자">
		<label for="withWho_4"><span>혼자</span></label>
	</div>
	<div class="check-box">
		<input type="radio" name="withWho" id="withWho_5" value="그 외">
		<label for="withWho_5"><span>그 외</span></label>
	</div>
</div>
		<div class="review-content">
			<label for="star">6. 전반적인 상품 이용 경험에 대해 평가해주세요.</label>
			<div>
			<div class="rating">
    			<i class="rating__star far fa-star"></i>
    			<i class="rating__star far fa-star"></i>
    			<i class="rating__star far fa-star"></i>
    			<i class="rating__star far fa-star"></i>
    			<i class="rating__star far fa-star"></i>
			</div>
   			 <span class="rating__result" id="star" name="star"></span>
   			 <input type="hidden" id="ratingValue" name="rating"> 
			</div>
		</div>
		<div class="review-content">
    <label for="photo">7. ADD SOME PHOTO(선택사항)</label>
    <div class="file-input-container">
        <div id="previewContainer"></div>
        <input type="file" id="fileUpload" name="reviewPhoto1" multiple='multiple' accept='image/*' />
    </div>
</div>
<button type="submit">리뷰작성</button>
		</form>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>