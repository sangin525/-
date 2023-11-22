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

      <div class="contentss" id="contents">
      
      
	<%@ include file="../common/nav2.jsp" %>
      

        <h3 class="secondtit">오시는 길</h3>
        <hr>
        <div id="map" style="width:800px;height:600px;margin-left:277px; margin-right:57px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2fa1debf9be449ec915f84b1b690158d"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.39918335362736, 126.92177635538705),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
        <br>

      </div>
    </div>
    </div>



	<%@ include file="../common/footer.jsp"%>
</body>
</html>