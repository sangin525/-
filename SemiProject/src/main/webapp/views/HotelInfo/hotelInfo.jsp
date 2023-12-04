<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
         
	
        <h3 class="secondtit">Hotel Haru</h3>
        <hr>
        <br>
        <div class="pic">
          <img src="/resources/uploads/개요사진.jpg" alt="개요사진">
        </div>
        <br>        
        <div class="content-box">
          <h3><Strong>호텔 개요</Strong></h3>
          <p>한국의 전통미와 현대적인 감각을 겸비하고 있는 세계 속의 명문 호텔 Hotel Haru는 철학이 있는 
            서비스와 격조 높은 휴식을 제공하는 프리미엄 라이프스타일 호텔입니다.
            전통적인 아름다움으로 귀한 손님을 맞이하던 영빈관과 피터 리미디우스가 디자인한 현대적인 감각의 인테리어,
            우아한 남산의 자연미가 어우러져 한국을 대표하는 호텔로서의 품격과 美를 지니고 있는 땡땡호텔은
            '컨템퍼러리 라이프스타일 데스티네이션' 이라는 컨셉을 새롭게 선보이면서 휴식은 물론,
            고급 식문화, 예술, 뷰티, 쇼핑, 웨딩, 엔터테인먼트 등 고객의 고품격 라이프스타일을 제안하는 공간으로 거듭나고 있습니다. </p><br>
            <h4><strong>글로벌 호텔</strong></h4>
            <p>LHW의 멤버로 세계 럭셔리 호텔들과 어깨를 나란히 하고 있는 땡땡호텔은 고객 한 분 한 분을 배려하는 기품 있는 서비스로 
              세계 각국의 수반들과 외교,경제, 문화 분야의 명사로부터 찬사를 받고 있으며, 
              Conde Nast Traveler, Travel&Leisure, Zagat, Euromoney 등 권위 있는 해외 매체로부터 
              매년 한국 최고의 호텔로 선정되고 있습니다.</p>
        </div>
        <br>

      </div>
      
      
    </div>
  </div>

	<%@ include file="../common/footer.jsp"%>

</body>
</html>