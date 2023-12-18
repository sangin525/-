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
          <img src="/resources/uploads/호텔수영장.jpg" alt="호텔수영장">
        </div>
        <br>        
        <div class="content-box">
          <h3>수영장소개</h3>
          <p>'도심 속 휴식의 섬' 컨셉의 야외 수영장입니다. 서울 특급호텔 최초 온수풀, 자쿠지, 루프탑(Rooftop), 카바나 등 차원이 다른 아웃도어 라이프스타일을 즐기실 수 있습니다. 계절마다 색다른 테마로 방문하실 때마다 새로운 경험을 제공합니다.
            </p><br>
            <h4><strong>운영시간 및 가격안내</strong></h4>
            <p>9:00am ~ 22:00pm</p>
            <p>성인: 20000원 어린이: 10000원</p>
            <h4><strong>주의 사항</strong></h4>
            <p> - 신장 140cm 미만인 고객은 성인 보호자의 보호 하에 구명조끼 착용 시 이용 가능합니다.</p>
            <p> - 다이빙은 금지되어 있습니다.</p>
            <p> - 물에 들어가기 전 반드시 준비운동을 해주시기 바랍니다.</p>
            <p> - 강우 및 태풍, 한파 등과 같은 기상 상황에 따라 수영장 이용이 제한될 수 있습니다.</p>
            <p> - 안전한 이용을 위해 안전 요원 및 직원의 안내가 있을 경우 적극적으로 협조해 주시기 바랍니다.</p><br>
            <h5>예약: 전화 또는 이메일문의(HotelHaru@naver.com)</h5>
        </div>
        <br>
      </div>
    </div>
  </div>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>