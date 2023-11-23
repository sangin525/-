<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/resources/css/hotelInfo/hotelInfo.css">
  <meta charset="UTF-8">
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
        </div>
        <br>
        <div class="pic">
          <img src="/resources/uploads/호텔오락실.jpg" alt="호텔오락실">
        </div>
        <br>        
        <div class="content-box">
          <h3>호텔 오락실</h3>
          <p>다양한 최신 기기와 가족 전체가 이용 가능한 게임기종을 다량 보유하여 즐거움을 느낄 수 있는 공간입니다.
            가족과 친구들과 함께 즐겨보세요.
          </p><br>
            <h4><strong>운영시간</strong></h4>
            <p>9:00am ~ 23:00pm</p>
        </div>
        <br>
      </div>
    </div>
  </div>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>