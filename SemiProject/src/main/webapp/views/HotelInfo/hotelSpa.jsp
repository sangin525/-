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
          <h4><a href="/hotel/HotelHealth.do">헬스장</a></h4>
        </div>
        <br>
        <div class="pic">
          <img src="/resources/uploads/호텔사우나.jpg" alt="호텔사우나">
        </div>
        <br>        
        <div class="content-box">
          <h3>호텔 사우나</h3>
          <p>프랑스 명품 코스메틱의 기술을 사용하여 최고의 서비스를 제공하는 도심 속 데스티네이션 스파를 즐겨보세요.
            호텔 사우나는 4계절 아름다운 남산의 전경을 볼 수 있는 지상 3층에 위치하여 자연 채광을 통한
            겔랑만의 향기를 제공하며 10개의 트리트먼트 룸과 5개의 족욕 라운지 등의 시설을 갖추어 도심 내 휴식을 제공하여 드립니다.</p><br>
            <h4><strong>운영시간 및 가격안내</strong></h4>
            <p>9:00am ~ 22:00pm</p>
            <p>성인: 20000원 어린이: 10000원</p><br>
            <h5>예약: 전화 또는 이메일문의(Hotel@Hotel.com)</h5>
        </div>
		<br>
      </div>      
    </div>
  </div>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>