<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/resources/css/hotelInfo/hotelInfo.css">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="../common/head.jsp"%>

</head>
<body class="Main_body">
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>

  <div class="contain">
    <div class="container">

	<%@ include file="../common/hotelInfoSidebar.jsp" %>
      <div class="contentss" id="contents">
      
	
        <h3 class="secondtit">호텔서비스</h3>
        <hr>
        <div class="sname">
          <h4><a href="/hotel/HotelPool.do">수영장</a></h4>
          <h4><a href="/hotel/HotelSpa.do">사우나</a></h4>
          <h4><a href="/hotel/HotelGame.do">오락실</a></h4>
          <h4><a href="/hotel/HotelHealth.do">헬스장</a></h4>
        </div>
        <br>
        <div class="pic">
          <img src="/resources/uploads/호텔헬스장.jpg" alt="호텔헬스장">
        </div>
        <br>        
        <div class="content-box">
          <h3>헬스장소개</h3>
          <p>호텔 하루 헬스장은 60여대 최첨단 ARTIS 장비와 다양한 전문 트레이너들의 도움으로 즐거움을 더해 드립니다.
            </p><br>
            <h4><strong>운영시간</strong></h4>
            <p>6:00am ~ 23:00pm</p>
            <h4><strong>전문 트레이너 PT</strong></h4>
            <p> 함께 관리하고 섬세하게 알려주실 트레이너 선생님과 함께 운동하세요.</p>
            <p>가격문의: 전화 또는 이메일문의(Hotel@Hotel.com)</p>
            <h4><strong>주의사항</strong></h4>
            <p> - 만 17세 이하는 헬스장 출입을 제한합니다.</p>
            <p> - 매월 마지막주 수요일은 정기 휴관입니다.</p>
         
            <br>
        </div>
        <br>
      </div>
    </div>
  </div>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>