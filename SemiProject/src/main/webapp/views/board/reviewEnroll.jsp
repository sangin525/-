<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<script src="/resources/js/board/review.js"></script>
<link rel="stylesheet" href="/resources/css/review.css">
<%@ include file="../common/head.jsp"%>
</head>
<body class="Main_body">
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<div class="review-container">
		<form action="/reviewEnroll.do" method="post" enctype="multipart/form-data">
			<div class="review-content">
				<div class="content-column">
					<div class="column-text">
						<label for="title" class="form-label">1. 호텔 하루 이용 중 가장 기억에
							남는 점을 알려주세요.<span class="textis-requied">*</span>
						</label> <input type="text" class="review-text" id="title" name="title"
							placeholder="제목입력(30자 이내)" required> <span
							class="text-muted">(0/30)</span>
					</div>
				</div>
			</div>
			<div class="review-content">
				<div class="content-column">
					<div class="textarea-box">
						<div class="column-text">
							<label for="content" class="form-label">2. 이용 중 경험을 작성해
								주세요.<span class="textis-requied">*</span>
							</label>
							<textarea class="review-area" id="content" name="content"
								required></textarea>
							<span class="text-muted">(0/500)</span>
						</div>
					</div>
				</div>
			</div>
			<div class="review-content">
				<div class="content-column">
					<div class="column-text">
						<label for="room" class="form-label">3. 이용하신 객실은 무엇인가요?</label> <input
							type="text" class="review-text" id="room" name="room"
							placeholder="객실 이름"> <span class="rv-commt">• 기억이
							나지 않으실 경우, 빈칸으로 남겨두세요.</span>
					</div>
				</div>
			</div>
			<div class="review-content">
				<div class="content-column">
					<label for="date" class="form-label">4. 언제 이용하셨나요?<span
						class="textis-requied">*</span></label>
					<div class="form-row">
						<div class="selectdate">
							<div class="selected-option" id="selectedYear">2023년</div>
							<span class="icon-arrow" id="icon-year"></span>
							<ul class="dropdown-options" id="dropdownOptionsYear"
								style="display: none;">
								<li data-value="2024년">2024년</li>
								<li data-value="2023년">2023년</li>
								<li data-value="2022년">2022년</li>
								<li data-value="2021년">2021년</li>
							</ul>
							<input type="hidden" name="year" id="year">
						</div>
						<div class="selectdate" style="margin-left: 30px;">
							<div class="selected-option" id="selectedMonth">1월</div>
							<span class="icon-arrow" id="icon-month"></span>
							<ul class="dropdown-options" id="dropdownOptionsMonth"
								style="display: none;">
								<li data-value="1월">1월</li>
								<li data-value="2월">2월</li>
								<li data-value="3월">3월</li>
								<li data-value="4월">4월</li>
								<li data-value="5월">5월</li>
								<li data-value="6월">6월</li>
								<li data-value="7월">7월</li>
								<li data-value="8월">8월</li>
								<li data-value="9월">9월</li>
								<li data-value="10월">10월</li>
								<li data-value="11월">11월</li>
								<li data-value="12월">12월</li>
							</ul>
							<input type="hidden" name="month" id="month">
						</div>
					</div>
				</div>
			</div>
			<div class="review-content">
				<div class="content-column">
					<label for="type" class="form-label">5. 누구와 함께 이용하셨나요?<span
						class="textis-requied">*</span></label>
					<div class="check-box">
						<input type="radio" name="withWho" id="withWho_0_unique"
							value="가족" required> <label for="withWho_0_unique"><span>가족</span></label>
					</div>
					<div class="check-box">
						<input type="radio" name="withWho" id="withWho_1_unique"
							value="친구"> <label for="withWho_1_unique"><span>친구</span></label>
					</div>
					<div class="check-box">
						<input type="radio" name="withWho" id="withWho_2_unique"
							value="커플"> <label for="withWho_2_unique"><span>커플</span></label>
					</div>
					<div class="check-box">
						<input type="radio" name="withWho" id="withWho_3_unique"
							value="비즈니스"> <label for="withWho_3_unique"><span>비즈니스</span></label>
					</div>
					<div class="check-box">
						<input type="radio" name="withWho" id="withWho_4_unique"
							value="혼자"> <label for="withWho_4_unique"><span>혼자</span></label>
					</div>
					<div class="check-box">
						<input type="radio" name="withWho" id="withWho_5_unique"
							value="그 외"> <label for="withWho_5_unique"><span>그
								외</span></label>
					</div>
				</div>
			</div>
			<div class="review-content">
				<div class="content-column">
					<label for="star" class="form-label">6. 전반적인 상품 이용 경험에 대해
						평가해주세요.<span class="textis-requied">*</span>
					</label>
					<div class="star-div">
						<div class="rating">
							<i class="rating__star far fa-star"></i> <i
								class="rating__star far fa-star"></i> <i
								class="rating__star far fa-star"></i> <i
								class="rating__star far fa-star"></i> <i
								class="rating__star far fa-star"></i>
						</div>
						<span class="rating__result" id="star" name="star"></span> <input
							type="hidden" id="ratingValue" name="rating">
					</div>
				</div>
			</div>
			<div class="review-content">
				<div class="content-column">
					<label for="photo" class="form-label">7. ADD SOME
						PHOTO(선택사항)</label>
					<div class="file-input-container">
    <div id="previewContainer"></div>
    <div class="file-input-container">
        <div id="previewContainer"></div>
        <label for="fileUpload1" class="custom-file-upload"> 
            <img src="/resources/uploads/review/더하기.png" alt="Upload" style="padding-top: 14px; width:100px; height: 64px;">
        </label> 
        <input type="file" id="fileUpload1" name="reviewPhoto1" accept='image/*' class="file-upload-input" />

        <label for="fileUpload2" class="custom-file-upload"> 
            <img src="/resources/uploads/review/더하기.png" alt="Upload" style="padding-top: 14px; width:100px; height: 64px;">
        </label> 
        <input type="file" id="fileUpload2" name="reviewPhoto2" accept='image/*' class="file-upload-input" />

        <label for="fileUpload3" class="custom-file-upload"> 
            <img src="/resources/uploads/review/더하기.png" alt="Upload" style="padding-top: 14px; width:100px; height: 64px;">
        </label> 
        <input type="file" id="fileUpload3" name="reviewPhoto3" accept='image/*' class="file-upload-input" />

        <label for="fileUpload4" class="custom-file-upload"> 
            <img src="/resources/uploads/review/더하기.png" alt="Upload" style="padding-top: 14px; width:100px; height: 64px;">
        </label> 
        <input type="file" id="fileUpload4" name="reviewPhoto4" accept='image/*' class="file-upload-input" />

        <label for="fileUpload5" class="custom-file-upload"> 
            <img src="/resources/uploads/review/더하기.png" alt="Upload" style="padding-top: 14px; width:100px; height: 64px;">
        </label> 
        <input type="file" id="fileUpload5" name="reviewPhoto5" accept='image/*' class="file-upload-input" />
    </div>
</div>
    <p class="img-p">• 최대 5개까지 첨부하실 수 있습니다.</p>
	<p class="img-p">• 첨부가능 파일 : jpg, png, gif, jpeg (용량 5MB)</p>
				</div>
			</div>
			<br> <br> <br>
			<div class="review-btn">
				<button type="submit" class="left-btn" id="submitBtn">리뷰작성</button>
			</div>
		</form>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>