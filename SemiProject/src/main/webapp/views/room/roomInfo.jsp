<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
 <style src="/resources/css/room.css"></style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<%@ include file="../common/head.jsp" %>
</head>
<body>
 <script src="/resources/js/room.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/nav.jsp" %>
  <section class="Main_section">
<!--     <h1>객실정보</h1> -->
	${roomDetail.roomName}
        	${roomDetail.roomInfo}
        	${roomDetail.roomGrade}
        	${roomDetail.roomNotice}
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
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop${count}" >
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
      <div class="modal-body">
<%--         	${roomDetail.roomName} --%>
<%--         	${roomDetail.roomInfo} --%>
<%--         	${roomDetail.roomGrade} --%>
<%--         	${roomDetail.roomNotice} --%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">예약하기</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
  	<hr>
  </c:forEach>
  
        
  
    <p> 안녕하세요! 객실안내홈페이지입니다</p>
  </section>

	<%@ include file="../common/footer.jsp" %>
</body>
</html>