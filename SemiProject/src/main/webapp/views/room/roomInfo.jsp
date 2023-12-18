<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<link href="/resources/css/room/room.css" rel="stylesheet" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <%@ include file="../common/head.jsp" %>
<style>
.left-btn{
    width: 150px;
    font-family: 'sejong';
    font-size: 16px;
    border-radius: 5px;
    border: 1px solid rgb(224, 162, 86);
    background-color: rgba(0, 0, 0, 0);
    color: rgb(224, 162, 86);
    padding: 5px;
    cursor: pointer;
}

.left-btn:hover {
    color: white;
    background-color: rgb(224, 162, 86);
}
</style>
<!--datepicker-->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.9.2/i18n/jquery.ui.datepicker-ko.min.js"></script>
</head>
<body class="Main_body">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
 <script src="/resources/js/room/room.js"></script>
   <%@ include file="../common/header.jsp" %>
   <%@ include file="../common/nav.jsp" %>
   <select id="datepickerRoom" onchange="datepickerGrade()">
	   	<option value="" selected>---예약가능날짜확인---</option>
	   	<option value="디럭스">디럭스</option>
	   	<option value="프리미엄">프리미엄</option>
	   	<option value="스위트">스위트</option>
	   	<option value="로얄스위트">로얄스위트</option>
   </select>
	<select id="datepickerRoomMenu" onchange="disableDays()">
		<option value="" class="dropdown-item" selected>--선택--</option>
	</select>
	<span class="datepicker" id="datepicker"></span>
  <section class="Main_section" id="section_main">
<!--     <h1>객실정보</h1> -->
     <c:set var="DetailCount" value="0"></c:set>
  <c:forEach var="item" items="${room}">
     <c:set var="count" value="${count+1}"></c:set>
              <h2><strong>초특가여기어때 ${item.roomGrade}</strong></h2>
         <div id="carouselExampleIndicators${count}" class="carousel slide">
            <div class="carousel-indicators">
               <button type="button" data-bs-target="#carouselExampleIndicators${count}"
                  data-bs-slide-to="0" class="active" aria-current="true"
                  aria-label="Slide 1"></button>
               <button type="button" data-bs-target="#carouselExampleIndicators${count}"
                  data-bs-slide-to="1" aria-label="Slide 2"></button>
               <button type="button" data-bs-target="#carouselExampleIndicators${count}"
                  data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
               <div class="carousel-item active">
                  <img src="${item.photoPath}" class="d-block w-100" alt="호텔전경">
               </div>
               <div class="carousel-item">
                  <img src="${item.photoPath1}" class="d-block w-100" alt="호텔전경">
               </div>
               <div class="carousel-item">
                  <img src="${item.photoPath2}" class="d-block w-100" alt="호텔전경">
               </div>
            </div>
            <button class="carousel-control-prev" type="button"
               data-bs-target="#carouselExampleIndicators${count}" data-bs-slide="prev">
               <span class="carousel-control-prev-icon" aria-hidden="true"></span>
               <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button"
               data-bs-target="#carouselExampleIndicators${count}" data-bs-slide="next">
               <span class="carousel-control-next-icon" aria-hidden="true"></span>
               <span class="visually-hidden">Next</span>
            </button>
         </div>
         <div>
         <br>
            <div class="price_info">
               <ul><strong><h3>요금안내</h3></strong>
                  <li>평일요금 : ${item.weekdayPrice}</li>
                  <li>주말요금 : ${item.weekendPrice}</li>
               </ul>
               <ul><strong><h3>인원제한</h3></strong>
                  <li>최소인원 : ${item.roomMin}</li>
                  <li>최대인원 : ${item.roomMax}</li>
               </ul>
            </div>
           </div>
<!-- Button trigger modal -->
      		<button type="button" class="left-btn" data-bs-toggle="modal" data-bs-target="#staticBackdrop${count}" >
			  세부정보/예약하기
			</button>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop${count}" data-bs-backdrop="static" data-bs-keyboard="false" 
tabindex="-1" aria-labelledby="staticBackdropLabel${count}" aria-hidden="true" >
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel${count}">세부정보/예약하기</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <c:forEach var="i" begin="1" end="4">
	      <div class="modal-body">
		      <c:if test="${count == i}"> 
		
			      <c:forEach begin="${DetailCount}" end="${DetailCount +2}">
					    <div class="roomDetailBox">
		      				<input type="hidden" name="roomDetailGrade" id="roomDetailGrade${count}" value="${roomDetail.get(DetailCount).roomGrade}">
							<h4><strong>객실등급 :${roomDetail.get(DetailCount).roomGrade}</strong></h4> 
							<strong>객실이름 :  ${roomDetail.get(DetailCount).roomName}</strong><br>
							<p class="roomDetailP">${roomDetail.get(DetailCount).roomInfo}</p> <br>
							<strong>객실 구비사항 :  ${roomDetail.get(DetailCount).amenity}</strong><br><br>
							<ul class="roomDetailNotice">
								<li>${roomDetail.get(DetailCount).roomNotice}</li>
								<li>${roomDetail.get(DetailCount).roomNotice1}</li>
								<li>${roomDetail.get(DetailCount).roomNotice2}</li>
								<li>${roomDetail.get(DetailCount).roomNotice3}</li>
							</ul>
							
							<p class="roomDetailChk">
							 <input type="checkbox" class ="Detailcheckbox" id="Detailcheckbox${DetailCount}"
							 value="${roomDetail.get(DetailCount).roomName}"
							 onclick="getCheckboxValue(event , ${DetailCount}, ${count}),unlockChkBtn(event, ${DetailCount})">
							  
							  <label for="Detailcheckbox${DetailCount}" >선택하기</label>
							 </p>
					    </div> 
			      	<c:set var="DetailCount" value="${DetailCount +1 }"></c:set>
			      </c:forEach>
		      </c:if>
	      </div>
      </c:forEach>
      
	      <div class="modal-footer" >
		    <input type="text" placeholder="객실이름" class="R_room_small" name="R_name" id="R_name${count}" disabled>
			<input type="date" required  class="R_room" name="start_date" id="start_date${count}" onchange="dateSum(${count}); checkReserveInfo(${count})" >
			 <input type="date" required class="R_room" name="end_date" id="end_date${count}"  onchange="dateSum(${count}); checkReserveInfo(${count})">
			 <input type="number" placeholder="숙박일" name="date_sum" class="R_room_small" id="date_sum${count}"  disabled>
			<input type="number" required placeholder="인원수" min="1" max="4" name="R_person_count" id="R_person_count${count}" class="R_room_small">

			<c:choose>
				<c:when test="${sessionScope.no !=null}">
					<button type="button" class="left-btn" 
	       				 onclick="reserveRoom(${count})">예약하기</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="left-btn"
						onclick="alert('로그인후 이용해주세요')">예약하기</button>
				</c:otherwise>
			</c:choose>
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="unChkBtn()">Close</button>
	      </div>
      
    </div>
  </div>
</div>
     <hr>
  </c:forEach>
  <div>
	<a href="http://pf.kakao.com/_PNxjXG" class="btn_kakao" style="display:none;">
	  <img src="/resources/uploads/mainPic/카카오로고.png" style="width:65px; height:70px">
	  </a>
	<a href="#" class="btn_gotop" style="display:none;">
	  <img src="/resources/uploads/mainPic/위로버튼.png" style="width:100px; height:100px">
	</a>
</div>
        
  
    <p> 안녕하세요! 객실안내홈페이지입니다</p>
  </section>

   <%@ include file="../common/footer.jsp" %>
</body>
</html>